package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        String id;
        if (args.length==2 && args[0].equals("-d")) {
            id = args[1].trim();
        } else if (args.length==5 && args[0].equals("-u")) {
            id = args[1].trim();
        } else return;

        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        ArrayList<String> list = new ArrayList<>();
        reader = new BufferedReader(new FileReader(fileName));
        String line, lineId;
        while (reader.ready()) {
            line = reader.readLine();
            lineId = line.substring(0,8).trim();
            if (lineId.equals(id)) {
                if (args[0].equals("-d")) {
                    continue;
                } else if (args[0].equals("-u")) {
                    line = String.format("%-8s%-30s%-8s%-4s", id, args[2], args[3], args[4]);
                }
            }
            list.add(line);
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String s : list) {
            writer.write(s);
            writer.newLine();
        }
        writer.close();

    }
}
