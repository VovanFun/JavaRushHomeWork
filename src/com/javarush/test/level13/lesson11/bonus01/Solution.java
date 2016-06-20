package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        ArrayList<Integer> list= new ArrayList<>();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready())
        {
            int f = Integer.parseInt(fileReader.readLine());
            if (f%2==0)
                list.add(f);
        }

        fileReader.close();

        // сортируем
        Collections.sort(list);
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = list.size()-1; j > i; j--) {
//                int t2 = list.get(j);
//                int t1 = list.get(j-1);
//                if (t2<t1) {
//                    list.set(j, t1);
//                    list.set(j-1, t2);
//                }
//            }
//        }

        for (int i : list) {
            System.out.println(i);
        }

    }
}
