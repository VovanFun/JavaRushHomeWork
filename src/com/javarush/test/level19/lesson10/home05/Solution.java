package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length!=2) return;

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileOutputStream writer = new FileOutputStream(args[1]);
        boolean first = true;
        while (reader.ready()) {
            String[] line = reader.readLine().split(" ");
            for (String s:line) {
                if (s.matches(".*\\d.*")) {
                    // . - любой символ(ровно 1), а .* - любое количество любых символов(даже их отсутствие).
                    if (first) first = false;
                    else writer.write(' ');

                    writer.write(s.getBytes());
                }
            }
        }
        reader.close();
        writer.close();
    }
}
