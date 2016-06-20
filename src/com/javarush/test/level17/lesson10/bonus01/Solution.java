package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if ((args.length==4) && ( args[0].equals("-c")) ) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date thedate = null;
            try {
                thedate = dateFormat.parse(args[3]);
            } catch (ParseException e) {
                e.printStackTrace();
                return;
            }
            if (args[2].equals("м"))
                allPeople.add(Person.createMale(args[1], thedate));
            else if (args[2].equals("ж"))
                    allPeople.add(Person.createFemale(args[1], thedate));
            System.out.println(allPeople.size()-1);
        }
        else if ((args.length==5) && ( args[0].equals("-u")) ) {
            Person person = allPeople.get(Integer.parseInt(args[1]));

            person.setName(args[2]);
            if (args[3].equals("м")) person.setSex(Sex.MALE);
            else if (args[3].equals("ж")) person.setSex(Sex.FEMALE);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date theDate = null;
            try {
                theDate = dateFormat.parse(args[4]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            person.setBirthDay(theDate);
        }
        else if (args.length == 2) {
            int id = Integer.parseInt(args[1]);
            Person p = allPeople.get(id);
            if (args[0].equals("-d")) {
                p.setName("");
                p.setSex(null);
                p.setBirthDay(null);
            }
            else if (args[0].equals("-i")) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(p.getName() + " " + getSexStr(p.getSex()) + " " + (p.getBirthDay()==null ? "" : dateFormat.format(p.getBirthDay())));
            }
        }
    }

    public static String getSexStr(Sex sex) {
        if (sex == Sex.MALE) return "м";
        if (sex == Sex.FEMALE) return "ж";
        return "";
    }

}
