package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2000"));
    }

    public static boolean isDateOdd(String date) throws ParseException {

/*
        Date thedate = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH).parse(date);
        Date thedate0 = (Date)thedate.clone();
*/

        Date d0 = new Date(date);
        Date d1 = new Date(date);
        d0.setHours(0);
        d0.setMinutes(0);
        d0.setSeconds(0);
        d0.setDate(1);
        d0.setMonth(0);
        long msTimeDistance = d1.getTime() - d0.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int y = (int)(msTimeDistance/msDay);

        return (y%2==0);
    }
}
