package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length!=1) return;

        String fileName = args[0];

        TreeMap<String, Double> treeMap = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String line = reader.readLine();
            int ind = line.lastIndexOf(' ');
            String key = line.substring(0, ind);
            Double val = Double.valueOf(line.substring(ind+1));
            Double val0 = treeMap.get(key);
            if (val0==null) val0=0.;
            treeMap.put(key, val0+val);
        }
        reader.close();

        for (Map.Entry<String, Double> pair: treeMap.entrySet() ) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }


    }
}
