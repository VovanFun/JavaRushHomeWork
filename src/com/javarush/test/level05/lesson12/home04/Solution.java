package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
//        Date d1 = new Date();
//        System.out.println(d1.toString());
        Calendar now = Calendar.getInstance();
        String thedate = new SimpleDateFormat("dd MM yyyy").format(now.getTime());
        System.out.println(thedate);

    }
}
