package com.javarush.test.level14.lesson06.home01;

class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 10;
    }
    String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), Country.RUSSIA,
                this.getCountOfEggsPerMonth());
    }
}


