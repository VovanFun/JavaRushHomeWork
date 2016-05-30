package com.javarush.test.level04.lesson13.task05;

import java.io.*;

/* Все любят Мамбу
Ввести с клавиатуры имя и используя цикл for 10 раз вывести: [*имя* любит меня.]
Пример текста:
Света любит меня.
Света любит меня.
…
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        for (int i = 0; i < 10; i++) {
            System.out.println(s + " любит меня.");
        }
*/

        String str1 = "string";
        String str2 = "string";
        System.out.println(str1==str2 ? "the same" : "not the same");

        String str10 = "string";
        String str20 = "str";
        String str30 = "ing";
        System.out.println(str1==(str20+str30) ? "the same" : "not the same");

        String str11 = "string";
        String str21 = new String("string");
        System.out.println(str11==str21 ? "the same" : "not the same");

        String str12 = "string";
        String str22 = new String("string");
        System.out.println(str12.intern()==str22.intern() ? "the same" : "not the same");

    }
}
