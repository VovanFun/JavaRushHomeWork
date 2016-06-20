package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        String file3 = bufferedReader.readLine();
        bufferedReader.close();

        FileOutputStream writer = new FileOutputStream(file1);
        FileInputStream reader2 = new FileInputStream(file2);
        FileInputStream reader3 = new FileInputStream(file3);

        if (reader2.available()>0) {
            byte[] bufer2 = new byte[reader2.available()];
            int count2 = reader2.read(bufer2);
            writer.write(bufer2, 0, count2);
        }
        reader2.close();

        if (reader3.available()>0) {
            byte[] bufer3 = new byte[reader3.available()];
            int count3 = reader3.read(bufer3);
            writer.write(bufer3, 0, count3);
        }
        reader3.close();
        writer.close();

    }
}
