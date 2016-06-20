package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length==0) return;

        FileInputStream file = new FileInputStream(args[0]);

        int count = 0;
        while (file.available()>0) {
            Character c = (char)file.read();
            if (String.valueOf(c).matches("[a-zA-Z]")) count++;
        }
        file.close();
        System.out.println(count);

    }
}
