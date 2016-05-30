package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/


public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human gf1 = new Human("Дед1", true, 77, null, null);
        Human gf2 = new Human("Дед2", true, 88, null, null);
        Human gm1 = new Human("Баба1", false, 67, null, null);
        Human gm2 = new Human("Баба2", false, 76, null, null);
        Human f = new Human("Отец", true, 46, gf1, gm1);
        Human m = new Human("Мать", false, 35, gf2, gm2);
        Human ch1 = new Human("Аня", false, 12, f, m);
        Human ch2 = new Human("Катя", false, 15, f, m);
        Human ch3 = new Human("Игорь", true, 18, f, m);

        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gm1);
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
        public String name;
        public Boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, Boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
