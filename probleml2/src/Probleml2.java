import shapes.*;

import java.util.ArrayList;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Probleml2 {
    public static void main(String... args) {
        Circle circle = new Circle(10);
        Quadrangle quadrangle = new Quadrangle(2, 3, 2, 3);
        Parallelogram parallelogramSquare = new Parallelogram(3),
                parallelogramRectangle = new Parallelogram(3, 2),
                parallelogramParallHight = new Parallelogram(3, 2, 3),
                parallelogramQuadr = new Parallelogram(3, 2, 3, 2);
        Trapezium trapeziumDowHigh = new Trapezium(4,2,2),
                trapeziumFullSides = new Trapezium(2,3,2,4);
        parallelogramQuadr.calcArea();
        System.out.println("c");

    }
}
