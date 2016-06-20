package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<Byte> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte cur;
        while (fileInputStream.available()>0) {
            cur = (byte) fileInputStream.read();
            if (!list.contains(cur))
                list.add(cur);
        }
        bufferedReader.close();
        fileInputStream.close();

        if (list.isEmpty()) return;

        Collections.sort(list);

        boolean first = true;
        for (Byte i: list) {
            if (!first) System.out.print(" ");
            if (first) first = false;
            System.out.print(i);
        }

    }
}
