package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = bufferedReader.readLine();
        OutputStream outputStream = new FileOutputStream(fileName);

        ArrayList<String> strings = new ArrayList<>();
        String line, exit = "exit";
        while (true)
        {
            line = bufferedReader.readLine();
            if (line.equals(exit))
                break;
            strings.add(line);
        }
        for (String s: strings) {
            outputStream.write(s.getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }

        outputStream.write(exit.getBytes());

        outputStream.close();
        bufferedReader.close();

    }
}
