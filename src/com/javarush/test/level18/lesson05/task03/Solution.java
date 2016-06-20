package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream writer2 = new FileOutputStream(file2);
        FileOutputStream writer3 = new FileOutputStream(file3);

        int count = inputStream.available();
        if (count==0) return;
        int count3 = count/2;
        int count2 = count-count3;

        byte[] buffer2 = new byte[count2];
        count2 = inputStream.read(buffer2);
        writer2.write(buffer2, 0, count2);

        byte[] buffer3 = new byte[count3];
        count3 = inputStream.read(buffer3);
        writer3.write(buffer3, 0, count3);

        inputStream.close();
        writer2.close();
        writer3.close();

    }
}
