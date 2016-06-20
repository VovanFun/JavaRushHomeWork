package com.javarush.test.level14.lesson06.home01;

class BelarusianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 40;
    }
    String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), Country.BELARUS, this.getCountOfEggsPerMonth());
    }
}
