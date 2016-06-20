package com.javarush.test.level15.lesson12.home04;

public class Earth implements Planet {

    private static Earth instance;
    private Earth(){}
    public static Earth getInstance(){
        if (instance==null) instance = new Earth();
        return instance;
    }


//    private static class EarthHelper{
//        private static final Earth INSTANCE = new Earth();
//    }
//    public static Earth getInstance(){
//        return EarthHelper.INSTANCE;
//    }
}
