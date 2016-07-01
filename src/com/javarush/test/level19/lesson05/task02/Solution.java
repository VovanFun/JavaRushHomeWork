package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        int countWorld = 0;
        BufferedReader reader2 = new BufferedReader(new FileReader(fileName));
        String word = "";
        while (reader2.ready()) {
            String[] line = reader2.readLine().split("[., !?;:-]");
            for (String s: line) {
                word = s.trim().toLowerCase();
                if (word.equals("world")) countWorld++;
            }
        }
        reader2.close();
        System.out.println(countWorld);
    }
}
