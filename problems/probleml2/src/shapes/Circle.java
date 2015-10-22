package shapes;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Circle extends ShapeAbstract {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        this.area = Math.PI * this.radius * this.radius;
        return this.area;
    }

    @Override
    public double calcPerimeter() {
        this.perimeter = 2 * Math.PI * this.radius;
        return this.perimeter;
    }
}
