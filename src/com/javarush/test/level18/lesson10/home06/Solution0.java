package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution0 {
    public static void main(String[] args) throws IOException {

        if (args.length==0) return;

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        int[] ascii = new int[256];
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            char[] cs = s.toCharArray();
            for (char c: cs) {
                ascii[c] = ++ascii[c];
            }
        }
        fileReader.close();

        for (int j = 0; j < 256; j++) {
            if (ascii[j]>0)
                System.out.println((char)j + " " + ascii[j]);
        }

    }
}
