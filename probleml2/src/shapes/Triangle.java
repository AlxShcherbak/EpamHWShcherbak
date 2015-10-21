package shapes;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Triangle extends ShapeAbstract {
    double sideLeft;
    double sideRight;
    double sideDown;

    public Triangle(double side) {
        this.sideLeft = side;
        this.sideDown = side;
        this.sideRight = side;
    }

    public Triangle(double sideLeft, double sideDown) {
        this.sideLeft = sideLeft;
        this.sideRight = sideLeft;
        this.sideDown = sideDown;
    }

    public Triangle(double sideLeft, double sideRight, double sideDown) {
        this.sideLeft = sideLeft;
        this.sideRight = sideRight;
        this.sideDown = sideDown;
    }

    @Override
    public double calcArea() {
        this.perimeter = calcPerimeter();
        this.area = Math.sqrt(this.perimeter * (this.perimeter - this.sideLeft) * (this.perimeter - this.sideRight) *
                (this.perimeter - this.sideDown));
        return this.area;
    }

    @Override
    public double calcPerimeter() {
        this.perimeter = this.sideDown + this.sideRight + this.sideLeft;
        return this.perimeter;
    }
}
