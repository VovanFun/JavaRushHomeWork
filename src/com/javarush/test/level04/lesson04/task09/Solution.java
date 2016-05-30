package com.javarush.test.level04.lesson04.task09;

/* Светофор
Работа светофора для пешеходов запрограммирована следующим образом: в начале каждого часа в течение трех минут горит зеленый сигнал,
затем в течение одной минуты — желтый, а потом в течение одной минуты — красный, затем опять зеленый горит три минуты и т. д.
Ввести с клавиатуры вещественное число t, означающее время в минутах, прошедшее с начала очередного часа.
Определить, сигнал какого цвета горит для пешеходов в этот момент.
Результат вывести на экран в следующем виде:
"зеленый" - если горит зеленый цвет, "желтый" - если горит желтый цвет, "красный" - если горит красный цвет.
Пример для числа 2.5:
зеленый
Пример для числа 3:
желтый
Пример для числа 4:
красный
Пример для числа 5:
зеленый
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float f = Float.parseFloat(reader.readLine());

        int green = 0, red = 0, yellow = 0;

        for (int i = 1; i <= 60; i++) {

            if ((red == 0 ) & (yellow == 0)) {
                if (green < 3) green++;
                else {yellow++; green=0;}
            } else if ((red == 0 ) & (green == 0)) {
                yellow=0; red++;
            } else if ((yellow == 0 ) & (green == 0)) {
                red = 0;
                green++;
            }

            if ((float)i>f) {
                if (green>0)
                    System.out.println("зеленый");
                else
                if (yellow>0)
                    System.out.println("желтый");
                else
                if (red>0)
                    System.out.println("красный");
                break;
            }
        }

    }
}