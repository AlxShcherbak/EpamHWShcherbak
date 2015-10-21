package shapes;

/**
 * Created by AlxEx on 21.10.2015.
 */
public abstract class ShapeAbstract {
    double area;
    double perimeter;

    public double getArea() {
        if (this.area == 0) this.calcArea();
        return this.area;
    }

    public double getPerimeter() {
        if (this.perimeter == 0) this.calcPerimeter();
        return this.perimeter;
    }

    public abstract double calcArea();

    public abstract double calcPerimeter();

    public double addAreas(ShapeAbstract shapeSec) {
        return this.getArea() + shapeSec.getArea();
    }
}
