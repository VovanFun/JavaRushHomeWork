package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static {
        threads.add(new Eternal());
        threads.add(new Excetp());
        threads.add(new Ura());
        threads.add(new MessageShow());
        threads.add(new Sum());

    }

    public static class Eternal extends Thread {

        @Override
        public void run() {
            while (true) {}
        }
    }

    public static class Excetp extends Thread {
        @Override
        public void run() {

            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Ura extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                System.out.println("Ура");
                }
            }
        }

    public static class MessageShow extends Thread implements Message {

        @Override
        public void run() {
            while (!this.isInterrupted()) {}
        }

        @Override
        public void showWarning() {

            this.interrupt();
            try {
                join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Sum extends Thread {
        @Override
        public void run() {
            int sum = 0;
            String s = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    s = reader.readLine();
                } catch (IOException e) {

                }
                if (s.equals("N"))
                    break;
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }
}
