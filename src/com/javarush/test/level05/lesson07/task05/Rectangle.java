package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота).
Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    public int top, left, width, height;

    //напишите тут ваш код
    public void initialize (int top, int left, int width, int height) {
        this.top = top;
        this.left =left;
        this.width = width;
        this.height = height;
    }

    public void initialize (int top, int left) {
        this.initialize(top, left, 0, 0);
    }

    public void initialize (int top, int left, int width) {
        this.initialize(top, left, width, width);
    }

    public void initialize (Rectangle rectangle) {
        this.initialize(rectangle.top, rectangle.left, rectangle.width, rectangle.height);
    }

}
