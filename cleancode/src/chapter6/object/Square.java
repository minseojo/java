package chapter6.object;

import chapter6.good.Point;

public class Square implements Shape {
    private Point topLeft;
    private double side;

    public double area() {
        return side * side;
    }
}
