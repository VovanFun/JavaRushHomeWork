package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Byte, Integer> map = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte cur;
        while (fileInputStream.available()>0) {
            cur = (byte) fileInputStream.read();
            Integer V = map.get(cur);
            if (V!=null) V++;
            else V = 1;
            map.put(cur, V);
        }
        bufferedReader.close();
        fileInputStream.close();
        if (map.isEmpty()) return;

        int qty = Integer.MAX_VALUE;
        for (Integer i: map.values()) {
            if (i<qty) qty = i;
        }

        boolean first = true;
        for (Map.Entry<Byte, Integer> pair: map.entrySet()) {
            if (pair.getValue()==qty) {
                if (!first) System.out.print(" ");
                if (first) first = false;
                System.out.print(pair.getKey());
            }
        }
    }
}
