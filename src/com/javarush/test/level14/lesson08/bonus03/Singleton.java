package com.javarush.test.level14.lesson08.bonus03;

public class Singleton {

    private final static Singleton singleton = new Singleton();

    private Singleton() {
    }

    static Singleton getInstance() {
        return Singleton.singleton;
    }
}
