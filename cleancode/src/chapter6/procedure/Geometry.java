package chapter6.procedure;

import java.util.NoSuchElementException;

public class Geometry {
    public final double PI = 3.1415926535;

    public double area(Object shape) throws NoSuchElementException {
        if (shape instanceof Square) {
            Square s = (Square) shape;
            return s.side * s.side;
        }
        else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.height * r.width;
        }
        else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return PI * c.radius * c.radius;
        }

        throw new NoSuchElementException();
    }
}
