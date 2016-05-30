package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = reader.readLine().toCharArray();

        //напишите тут ваш код
        boolean cap = true;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == ' ')
                cap = true;
            else if (cap) {
                chars[i] = Character.toUpperCase(chars[i]);
                cap = false;
            }
        }

        String s = new String(chars);
        System.out.println(s);
    }


}
