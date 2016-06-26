package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length==0) return;

        String id = args[0];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()) {

            String line = reader.readLine();
            if (line.isEmpty()) continue;
            String[] s = line.split(" ");
            if (s[0].equals(id))
                System.out.println(line);

        }

        reader.close();


    }
}
