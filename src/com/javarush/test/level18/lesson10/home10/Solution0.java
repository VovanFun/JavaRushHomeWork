package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution0 {
    public static void main(String[] args) throws IOException {

        TreeSet<String> fileNameSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = Integer.parseInt(o1.substring(o1.lastIndexOf('.')+5));
                int j = Integer.parseInt(o2.substring(o2.lastIndexOf('.')+5));
                if (i>j) return 1;
                else if (i<j) return -1;
                else return 0;
            }
        });

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName;
        while (true) {
            fileName = reader.readLine();
            if (fileName.equals("end")) break;
            if (fileName.isEmpty()) continue;
            fileNameSet.add(fileName);
        }
        reader.close();
        if (fileNameSet.size()==0) return;

        fileName = fileNameSet.first();
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
        File file = new File(fileName);
        if (file.exists()) file.delete();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        FileInputStream fileReader;
        for (String s: fileNameSet) {
            fileReader = new FileInputStream(s);
            byte[] b = new byte[fileReader.available()];
            fileReader.read(b);
            fileOutputStream.write(b);
            fileReader.close();
        }
        fileOutputStream.close();

    }
}
