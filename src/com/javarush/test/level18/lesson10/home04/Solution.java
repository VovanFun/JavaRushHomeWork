package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream reader1 = new FileInputStream(file1);
        FileInputStream reader2 = new FileInputStream(file2);

        int a1 = reader1.available();
        int a2 = reader2.available();
        byte[] bufer = new byte[a1+a2];

        int count1=0, count2=0;
        if (a2>0) {
            count2 = reader2.read(bufer);
        }
        reader2.close();

        if (a1>0) {
            reader1.read(bufer, count2, a1);
        }
        reader1.close();

        FileOutputStream writer = new FileOutputStream(file1);
        writer.write(bufer);
        writer.close();

    }
}
