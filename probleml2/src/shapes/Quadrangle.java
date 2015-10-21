package shapes;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Quadrangle extends ShapeAbstract {
    double sideTop;
    double sideLeft;
    double sideDown;
    double sideRight;

    protected Quadrangle() {
    }

    public Quadrangle(double sideTop, double sideLeft, double sideDown, double sideRight) {
        this.sideTop = sideTop;
        this.sideLeft = sideLeft;
        this.sideDown = sideDown;
        this.sideRight = sideRight;
    }

    @Override
    public double calcArea() {
        this.calcPerimeter();
        this.area = Math.sqrt((this.perimeter / 2 - this.sideTop) * (this.perimeter / 2 - this.sideLeft) *
                (this.perimeter / 2 - this.sideDown) * (this.perimeter / 2 - this.sideRight));
        return this.area;
    }

    @Override
    public double calcPerimeter() {
        this.perimeter = this.sideTop + this.sideLeft + this.sideDown + this.sideRight;
        return this.perimeter;
    }
}
