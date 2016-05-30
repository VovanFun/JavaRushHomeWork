package com.javarush.test.level08.lesson08.task05;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args) {

        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (String s : map.keySet())
            System.out.println(s);

    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("Fam"+i, "Name"+i);
        }
//        map.put("Сидоров", "Сергей");
//        map.put("Иванов", "Андрей");
//        map.put("Белов", "Григорий");
//        map.put("Серов", "Николай");
//        map.put("Ниулин", "Сергей");
//        map.put("Жиглов", "Андрей");
//        map.put("Иванов", "Николай");
//        map.put("Сидорович", "Андрей");
//        map.put("Николенко", "Сергей");
//        map.put("Смирнов", "Александр");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<>(map);
        for (String s : copy.values())
            if (Collections.frequency(copy.values(), s)> 1)
                removeItemFromMapByValue(map, s);

//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext())
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
