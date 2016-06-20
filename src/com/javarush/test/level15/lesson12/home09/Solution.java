package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();

        if (url.isEmpty()) return;

        char[] cc = url.toCharArray();
        boolean isParamsBegin = false;
        boolean isParamValueBegin = false;
        String paramName = "";
        String paramValue = "";
        ArrayList<String> nameArray = new ArrayList<>();
        ArrayList<String> valueArray = new ArrayList<>();
        for (char c : cc) {
            if ((c == '?') || (isParamsBegin && c == '&')) {
                isParamsBegin = true;
                if (!paramName.isEmpty()) {
                    nameArray.add(paramName);
                    valueArray.add(paramValue);
                }
                paramName = "";
                paramValue = "";
                isParamValueBegin = false;
                continue;
            }

            if (isParamsBegin && c == '=') {
                isParamValueBegin = true;
                continue;
            }

            if (isParamsBegin && !isParamValueBegin) paramName += c;
            else if (isParamsBegin && isParamValueBegin) paramValue += c;
        }
        if (!paramName.isEmpty()) {
            nameArray.add(paramName);
            valueArray.add(paramValue);
        }

        boolean first = true;
        for (String m : nameArray) {
            if (first) first = false;
            else System.out.print(" ");

            System.out.print(m);
        }
        System.out.println();

        for (int i = 0; i < nameArray.size(); i++) {
            if (nameArray.get(i).equals("obj")) {
                paramValue = valueArray.get(i);
                try {
                    alert(Double.parseDouble(paramValue));
                } catch (NumberFormatException e) {
                    alert(paramValue);
                }
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
