package chapter6.object;

import chapter6.good.Point;

public class Rectangle implements Shape {
    private Point topLeft;
    private double height;
    private double width;

    public double area() {
        return height * height;
    }
}
