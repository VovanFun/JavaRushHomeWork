package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) {

        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);

        for (String name : map.keySet())
            System.out.println(name);

    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();

        //напишите тут ваш код

        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Arnold", new Date("MAY 1 1990"));
        map.put("Obama", new Date("JULY 1 1990"));
        map.put("VanDam", new Date("DECEMBER 1 1990"));
        map.put("VanGoh", new Date("AUGUST 1 1990"));
        map.put("Vancent", new Date("SEPTEMBER 1 1990"));
        map.put("Banderos", new Date("NOVEMBER 1 1990"));
        map.put("Gitler", new Date("OCTOBER 1 1990"));
        map.put("Worh", new Date("OCTOBER 1 1990"));
        map.put("Stef", new Date("OCTOBER 1 1990"));
        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<>();
        for (Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator(); iterator.hasNext() ; ) {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();

            if (value.getMonth() > 4 && value.getMonth() < 8)
                arrayList.add(pair.getKey());

        }

        for (String s : arrayList)
            map.remove(s);

    }
}
