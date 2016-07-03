package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    static String tagBegin1;
    static String tagBegin2;
    static String tagEnd;
    static String fileString;

    public static void main(String[] args) throws IOException {

        if (args.length==0) return;
        tagBegin1 = "<"+args[0]+">";
        tagBegin2 = "<"+args[0]+" ";
        tagEnd = "</"+args[0]+">";
//        Pattern pattern = Pattern.compile("(<|(</))" + args[0] + "(>|\\s)|(\\n)");
//        Matcher matcher = pattern.matcher(content); // content - содержимое страницы в одну строку

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();
        fileString = new String(b).replaceAll("\n", " ").replaceAll("\r", " ");
        int indxQty, // quantity tags
                indx0, indx1=-1, indx2;

        while (true) {

            ArrayList<Integer> indxArray = new ArrayList<Integer>();

            indx0 = findBeginTag(indx1);
            if (indx0==-1) break;
            indx2 = fileString.indexOf(tagEnd, indx0);

            while (indx1<indx2) {
                indx1 = findBeginTag(indx1+1);
                if ((indx1<0)||(indx1>indx2)) break;
                indxArray.add(indx1);
            }

            StringBuilder sb = new StringBuilder();
            indx2 = indx0;
            for (int i = indxArray.size()-1; i >= 0 ; i--) {
                indx2 = fileString.indexOf(tagEnd, indx2+1);
                if (indx2<0) break;
                indx1 = indx2;
                sb.insert(0,fileString.substring(indxArray.get(i), indx2+tagEnd.length())+System.lineSeparator());
            }

            System.out.print(sb.toString());


        }
    }

    private static int findBeginTag(int indx) {
        int indx1, indx2;
        indx1 = fileString.indexOf(tagBegin1, indx);
        indx2 = fileString.indexOf(tagBegin2, indx);

        if (indx1<0) return indx2;
        if (indx2<0) return indx1;

        return indx1>indx1 ? indx1 : indx2;
    }
}
