package com.javarush.test.level03.lesson04.task01;

/* Дата рождения
Вывести на экран дату своего рождения в виде: MAY 1 2012
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        //напишите тут ваш код
        String myBirthday = "MAY 4 1972";
//        DateFormat format = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
//        Date date = format.parse(myBirthday);
        System.out.println(myBirthday);

        Calendar mydate = new GregorianCalendar();
        String mystring = "Jan 1 1972";
        Date thedate = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH).parse(mystring);
        mydate.setTime(thedate);

        System.out.println("mydate -> " + mydate);
        System.out.println("year   -> " + mydate.get(Calendar.YEAR));
        System.out.println("month  -> " + mydate.get(Calendar.MONTH));
        System.out.println("dom    -> " + mydate.get(Calendar.DAY_OF_MONTH));

        Calendar now = Calendar.getInstance();
        mydate.set(Calendar.YEAR, 2009);
        mydate.set(Calendar.MONTH, Calendar.FEBRUARY);
        mydate.set(Calendar.DAY_OF_MONTH, 25);
        mydate.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY));
        mydate.set(Calendar.MINUTE, now.get(Calendar.MINUTE));
        mydate.set(Calendar.SECOND,now.get(Calendar.SECOND));

//        ydate.set(2009, Calendar.FEBRUARY, 25, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));
        System.out.println("mydate -> "+mydate);
        System.out.println("year   -> "+mydate.get(Calendar.YEAR));
        System.out.println("month  -> "+mydate.get(Calendar.MONTH));
        System.out.println("dom    -> "+mydate.get(Calendar.DAY_OF_MONTH));
        System.out.println("dow    -> "+mydate.get(Calendar.DAY_OF_WEEK));
        System.out.println("hour   -> "+mydate.get(Calendar.HOUR));
        System.out.println("minute -> "+mydate.get(Calendar.MINUTE));
        System.out.println("second -> "+mydate.get(Calendar.SECOND));
        System.out.println("milli  -> "+mydate.get(Calendar.MILLISECOND));
        System.out.println("ampm   -> "+mydate.get(Calendar.AM_PM));
        System.out.println("hod    -> "+mydate.get(Calendar.HOUR_OF_DAY));

    }
}