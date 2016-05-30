package com.javarush.test.level03.lesson06.task05;

/* Изучаем японский
Выведи на экран 日本語
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        System.out.println("日本語" + System.getProperty("java.version"));

/*
//        1	Ввод строки и числа с клавиатуры
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String sAge = null; //читаем строку с клавиатуры
        try
        {
            String name = bufferedReader.readLine(); //читаем строку с клавиатуры
            sAge = bufferedReader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        int nAge = Integer.parseInt(sAge); //преобразовываем строку в число.

//        2	Более компактная запись первой части:
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        String sAge = reader.readLine();
        int nAge = Integer.parseInt(sAge);

//        3	Еще более компактная
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
*/
    }
}