package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        byte[] b = new byte[fileInputStream.available()];
        fileInputStream.read(b);
        fileInputStream.close();

        byte c = '.', a = '!';
        for (int i=0; i<b.length; i++) {
            if (b[i]==c) b[i] = a;
        }

        FileOutputStream fileWriter = new FileOutputStream(fileName2);
        fileWriter.write(b);
        fileWriter.close();

    }
}
