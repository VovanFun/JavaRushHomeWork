package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> lines1 = new ArrayList<String>();
    public static List<String> lines2 = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));
        while (reader1.ready()) {
            lines1.add(reader1.readLine());
        }
        reader1.close();
        while (reader2.ready()) {
            lines2.add(reader2.readLine());
        }
        reader2.close();

        String line1, line2, nextLine1, nextLine2;
        int line1maxIndx = lines1.size()-1;
        int line2maxIndx = lines2.size()-1;
        int i=0, j=0;
        do {
            if ((i>line1maxIndx)&&(j>line2maxIndx)) break;
            if (i>line1maxIndx) {
                for (int k = j; k <= line2maxIndx; k++) {
                    lines.add(new LineItem(Type.ADDED, lines2.get(k)));
                }
                break;
            }
            if (j>line2maxIndx) {
                for (int k = i; k <= line1maxIndx; k++) {
                    lines.add(new LineItem(Type.REMOVED, lines1.get(k)));
                }
                break;
            }

            line1 = lines1.get(i);
            line2 = lines2.get(j);
            if (line1.equals(line2)) {
                lines.add(new LineItem(Type.SAME, line1));
                i++;
                j++;
            } else {
                if (j+1>line2maxIndx) {
                    lines.add(new LineItem(Type.REMOVED, line1));
                    i++;
                    j++;
                    continue;
                }

                nextLine2 = lines2.get(j+1);
                if (line1.equals(nextLine2)) {
                    lines.add(new LineItem(Type.ADDED, line2));
                    j++;
                }
                else  {
                    lines.add(new LineItem(Type.REMOVED, line1));
                    i++;
                }
            }

        } while (true);

        for (LineItem li : lines) {
            System.out.println(li.type + " " + li.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
