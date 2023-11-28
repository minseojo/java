package chapter6.object;

import chapter6.good.Point;

public class Circle implements Shape {
    private Point center;
    private double radius;
    public final double PI = 3.1415926535;

    public double area() {
        return PI * radius * radius;
    }
}
