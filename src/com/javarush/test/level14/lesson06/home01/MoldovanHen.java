package com.javarush.test.level14.lesson06.home01;

class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 30;
    }
    String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), Country.MOLDOVA, this.getCountOfEggsPerMonth());
    }
}
