package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String sSalary = reader.readLine();
        int iSalary = Integer.parseInt(sSalary);
        String sYear = reader.readLine();
        int iYear = Integer.parseInt(sYear);
        System.out.println(name + " получает " + sSalary + " через " + sYear + " лет.");

    }
}