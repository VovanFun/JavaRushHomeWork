package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if ((a<=b & b<=c)||(c<=b & b<=a))
            System.out.println(b);
        else if ((a<=c & c<=b)||(b<=c & c<=a))
            System.out.println(c);
        else if ((b<=a & a<=c)||(c<=a & a<=b))
            System.out.println(a);
    }
}
