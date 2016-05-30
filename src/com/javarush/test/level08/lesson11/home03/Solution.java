package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        //напишите тут ваш код
        Map<String, String > map = new HashMap<>();

        map.put("Сидоров", "Сергей");
        map.put("Иванов", "Андрей");
        map.put("Белов", "Григорий");
        map.put("Серов", "Николай");
        map.put("Ниулин", "Сергей");
        map.put("Белов", "Андрей");
        map.put("Иванов", "Николай");
        map.put("Сидоров", "Андрей");
        map.put("Николенко", "Сергей");
        map.put("Смирнов", "Александр");
        return map;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
