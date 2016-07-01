package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        if (args.length!=1) return;
        String fileName = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int ind;
        while (reader.ready()) {
            line = reader.readLine();
            ind = line.lastIndexOf(" ");
            int year = Integer.valueOf(line.substring(ind+1));
            line = line.substring(0, ind);
            ind = line.lastIndexOf(" ");
            int month = Integer.valueOf(line.substring(ind+1))-1;
            line = line.substring(0, ind);
            ind = line.lastIndexOf(" ");
            int day = Integer.valueOf(line.substring(ind+1));
            GregorianCalendar calendar = new GregorianCalendar(year, month, day);
            Person person = new Person(line.substring(0, ind), calendar.getTime());
            PEOPLE.add(person);
        }
        reader.close();
        for (Person p: PEOPLE) {
            System.out.println(p.getName() + " " + p.getBirthday());
        }

    }

}
