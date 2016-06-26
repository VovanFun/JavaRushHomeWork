package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String file = reader.readLine();
            if (file.equals("exit")) break;
            ReadThread readThread = new ReadThread(file);
            readThread.start();
        }
        reader.close();

        for (Map.Entry<String, Integer> pair : resultMap.entrySet() ) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

    }

    public static class ReadThread extends Thread {

        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                int max = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                FileInputStream fileInputStream = new FileInputStream(this.fileName);
                while (fileInputStream.available()>0) {
                    int key = fileInputStream.read();
                    Integer val = map.get(key);
                    if (val==null) val = 0;
                    val++;
                    if (val>max) max = val;
                    map.put(key, val);
                }
                fileInputStream.close();
                for (Map.Entry<Integer, Integer> pair : map.entrySet() ) {
                    if (pair.getValue()==max) {
                        synchronized (this.fileName) {
                            resultMap.put(this.fileName, pair.getKey());
                        }
                        break;
                    }
                }
            } catch (IOException e) {
            }

        }

    }
}
