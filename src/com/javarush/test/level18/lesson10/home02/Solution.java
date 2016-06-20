package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length==0) return;
        FileReader fileReader = new FileReader(args[0]);
        int countSpace = 0, countAll = 0;
        while (fileReader.ready()) {
            char c = (char)fileReader.read();
            if (c==' ') countSpace++;
            countAll++;
        }
        fileReader.close();
        int rez = Math.round((float)countSpace/countAll*100*100);
        System.out.println(rez/100.0);
    }
}
