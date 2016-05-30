package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int qty = 5;
        int[] inArray = new int[qty];
        int[] outArray = new int[qty];


//        int a1 = Integer.parseInt(reader.readLine());
//        int a2 = Integer.parseInt(reader.readLine());
//        int a3 = Integer.parseInt(reader.readLine());
//        int a4 = Integer.parseInt(reader.readLine());
//        int a5 = Integer.parseInt(reader.readLine());

        for (int i = 0; i < qty; i++) {
            inArray[i] = Integer.parseInt(reader.readLine());
        }

        int p = 0;
        boolean k = true;
        while (k) {
            k = false;
            for (int i = 1; i < qty; i++) {
                if (inArray[i] < inArray[i - 1]) {
                    p = inArray[i - 1];
                    inArray[i - 1] = inArray[i];
                    inArray[i] = p;
                    k = true;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < qty; i++) {
            System.out.println(inArray[i]);
        }

    }
}
