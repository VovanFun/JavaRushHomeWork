package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution() {}
    public Solution(String s) {}
    public Solution(int i) {}

    protected Solution(String s1, String s2) {}
    protected Solution(double d, int i) {}
    protected Solution(double d, String s) {}

    private Solution(int i, String s) {}
    private Solution(int i1, int i2) {}
    private Solution(int i1, double d) {}

    Solution(double d1, double d2) {}
    Solution(String  s1, double d2) {}
    Solution(String  s1, int i2) {}

}

