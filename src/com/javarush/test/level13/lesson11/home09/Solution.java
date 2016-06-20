package com.javarush.test.level13.lesson11.home09;

import java.awt.*;

/* Один метод в классе
1. Унаследовать Fox от интерфейса Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод - getName.
3. Методы удалять нельзя!
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    public interface Animal
    {
//        Color getColor();
//
//        Integer getAge();
//    }
//
//    public static class AnimalFox implements Animal
//    {
//        @Override
//        public Color getColor() {
//            return Color.RED;
//        }
//
//        @Override
//        public Integer getAge() {
//            return 1;
//        }
    }

//    public static class Fox extends AnimalFox implements Animal
    public static class Fox implements Animal
    {
        public String getName()
        {
            return "Fox";
        }
    }
}
