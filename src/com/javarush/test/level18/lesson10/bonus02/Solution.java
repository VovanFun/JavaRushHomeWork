package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length<4) return;
        if (!args[0].equals("-c")) return;

        String productName = args[1];
        String price = args[2].trim();
        String quantity = args[3].trim();

        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fileName));
        String line = "";
        while (reader.ready()) {
            line = reader.readLine();
        }
        reader.close();
        int id = 0;
        if (!line.isEmpty()) {
            id = Integer.valueOf(line.substring(0, 8).trim());
        }
        line = String.format("%-8s%-30s%-8s%-4s", String.valueOf(++id), args[1], args[2], args[3]);
        FileOutputStream writer = new FileOutputStream(fileName, true);
        writer.write(System.lineSeparator().getBytes());
        writer.write(line.getBytes());
        writer.close();

    }
}
