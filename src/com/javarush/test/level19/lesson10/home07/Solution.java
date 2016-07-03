package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length<2) return;

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileOutputStream writer = new FileOutputStream(args[1]);
        boolean first = true;
        while (reader.ready()) {
            String[] line = reader.readLine().split(" ");
            for (String s: line) {
                if (s.length()>6) {
                    if (first) first=false;
                    else writer.write(',');
                    writer.write(s.getBytes());
                }
            }
        }
        reader.close();
        writer.close();

    }
}
