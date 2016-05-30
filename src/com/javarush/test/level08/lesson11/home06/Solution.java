package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> child = new ArrayList<>();
        Human ch1 = new Human("Аня", false, 12, child);
        Human ch2 = new Human("Катя", false, 15, child);
        Human ch3 = new Human("Игорь", true, 18, child);
        ArrayList<Human> children = new ArrayList<>();
        children.add(ch1);
        children.add(ch2);
        children.add(ch3);
        Human f = new Human("Отец", true, 46, children);
        ArrayList<Human> childF = new ArrayList<>();
        childF.add(f);
        Human m = new Human("Мать", false, 35, children);
        ArrayList<Human> childM = new ArrayList<>();
        childM.add(m);

        Human gf1 = new Human("Дед1", true, 77, childF);
        Human gf2 = new Human("Дед2", true, 88, childM);
        Human gm1 = new Human("Баба1", false, 67, childF);
        Human gm2 = new Human("Баба2", false, 76, childM);

        System.out.println(gf1);
        System.out.println(gm1);
        System.out.println(gf2);
        System.out.println(gm2);
        System.out.println(f);
        System.out.println(m);
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);

    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private Boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, Boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
