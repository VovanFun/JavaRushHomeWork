package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String firstname;
        private String lastname;
        private int age;
        private boolean sex;
        private String address;
        private int salary;

        public Human(String firstname) {
            this.firstname = firstname;
        }

        public Human(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public Human(String firstname, String lastname, int age) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.age = age;
        }

        public Human(String firstname, String lastname, int age, boolean sex) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstname, String lastname, int age, boolean sex, String address) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.age = age;
            this.sex = sex;
            this.address = address;
        }

        public Human(String firstname, String lastname, int age, boolean sex, String address, int salary) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.salary = salary;
        }

        public Human(String firstname, int age) {
            this.firstname = firstname;
            this.age = age;
        }

        public Human(String firstname, boolean sex) {
            this.firstname = firstname;
            this.sex = sex;
        }

        public Human(String firstname, int age, boolean sex) {
            this.firstname = firstname;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstname, int age, boolean sex, String address) {
            this.firstname = firstname;
            this.age = age;
            this.sex = sex;
            this.address = address;
        }
    }
}
