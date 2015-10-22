package shapes;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Trapezium extends Quadrangle {
    double high;

    public Trapezium(double sideTop, double sideDown, double high) {
        super();
        this.sideTop = sideTop;
        this.sideDown = sideDown;
        this.high = high;
    }

    public Trapezium(double sideTop, double sideLeft, double sideDown, double sideRight) {
        super(sideTop, sideLeft, sideDown, sideRight);
    }

    public Trapezium(double sideTop, double sideLeft, double sideDown, double sideRight, double high) {
        super(sideTop, sideLeft, sideDown, sideRight);
        this.high = high;
    }

    @Override
    public double calcArea() {
        if (this.high != 0) {
            this.area = (this.sideTop + this.sideDown) / 2 * high;
        } else this.area = super.calcArea();
        return this.area;
    }

    @Override
    public double calcPerimeter() {
        if (sideLeft == 0) try {
            throw new PerimeterCalculationUnposibleException("Trapezium perimeter uncalculated");
        } catch (PerimeterCalculationUnposibleException e) {
            e.printStackTrace();
            return 0;
        }
        else
            return super.calcPerimeter();

    }

    public class PerimeterCalculationUnposibleException extends Exception {
        public PerimeterCalculationUnposibleException() {
        }

        public PerimeterCalculationUnposibleException(String s) {
            super(s);
        }
    }
}
