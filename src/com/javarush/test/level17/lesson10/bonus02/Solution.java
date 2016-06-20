package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length < 2) return;
        SimpleDateFormat dateFormatCreate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        int beginIndx = 1;

        switch (args[0]) {
            case "-c" : {
                Date thedate;
                while (args.length >= beginIndx+2) {
                    try {
                        thedate = dateFormatCreate.parse(args[beginIndx+2]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return;
                    }
                    if (args[beginIndx+1].equals("м"))
                        allPeople.add(Person.createMale(args[beginIndx], thedate));
                    else if (args[beginIndx+1].equals("ж"))
                        allPeople.add(Person.createFemale(args[beginIndx], thedate));
                    System.out.println(allPeople.size() - 1);
                    beginIndx += 3;
                }

            }
            break;
            case "-u" : {
                Date thedate;
                while (args.length >= beginIndx+3) {
                    Person person = allPeople.get(Integer.parseInt(args[beginIndx]));

                    person.setName(args[beginIndx+1]);
                    if (args[beginIndx+2].equals("м")) person.setSex(Sex.MALE);
                    else if (args[beginIndx+2].equals("ж")) person.setSex(Sex.FEMALE);

                    Date theDate = null;
                    try {
                        theDate = dateFormatCreate.parse(args[beginIndx+3]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    person.setBirthDay(theDate);
                    beginIndx += 4;
                }
            }
            break;
            case "-d" : {
                while (args.length > beginIndx) {
                    int id = Integer.parseInt(args[beginIndx]);
                    Person p = allPeople.get(id);
                    p.setName("");
                    p.setSex(null);
                    p.setBirthDay(null);
                    beginIndx += 1;
                }
            }
            break;
            case "-i" : {
                while (args.length > beginIndx) {
                    int id = Integer.parseInt(args[beginIndx]);
                    Person p = allPeople.get(id);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    System.out.println(p.getName() + " " + getSexStr(p.getSex()) + " " + (p.getBirthDay()==null ? "" : dateFormat.format(p.getBirthDay())));

                    beginIndx++;
                }
            }
        }
    }

    public static String getSexStr(Sex sex) {
        if (sex == Sex.MALE) return "м";
        if (sex == Sex.FEMALE) return "ж";
        return "";
    }
}
