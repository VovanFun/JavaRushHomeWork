package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "Name1"));
        System.out.println(getCountTheSameLastName(map, "Fam1"));

    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            map.put("Fam"+i, "Name"+i);
        }
/*
        map.put("Сидоров", "Сергей");
        map.put("Иванов", "Андрей");
        map.put("Белов", "Григорий");
        map.put("Серов", "Николай");
        map.put("Ниулин", "Сергей");
        map.put("Жиглов", "Андрей");
        map.put("Иванов", "Николай");
        map.put("Сидорович", "Андрей");
        map.put("Николенко", "Сергей");
        map.put("Смирнов", "Александр");
*/
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;
        for (String firstName : map.values())
            if (firstName.equals(name))
                count++;
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int count = 0;
        for (String lastNames : map.keySet())
            if (lastNames.equals(lastName))
                count++;
        return count;

    }
}
