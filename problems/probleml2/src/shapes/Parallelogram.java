package shapes;

import shapes.enums.ParallelogramType;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Parallelogram extends Quadrangle {
    double high;
    ParallelogramType parallelogramType;

    /**
     * Square
     *
     * @param side - side of square
     */
    public Parallelogram(double side) {
        super();
        this.sideLeft = side;
        this.sideDown = side;
        this.parallelogramType = ParallelogramType.RECTANGLE;
    }

    /**
     * Rectangle - high = one of side
     */
    public Parallelogram(double sideLeft, double sideDown) {
        super();
        this.sideLeft = sideLeft;
        this.sideDown = sideDown;
        this.parallelogramType = ParallelogramType.RECTANGLE;
    }

    /**
     * parallelogram known high
     */
    public Parallelogram(double sideLeft, double sideDown, double high) {
        super();
        this.sideLeft = sideLeft;
        this.sideDown = sideDown;
        this.high = high;
        this.parallelogramType = ParallelogramType.PARALLELOGRAM;
    }

    /**
     * parallelogram unknown high -> Quadrangle
     */
    public Parallelogram(double sideTop, double sideLeft, double sideDown, double sideRight) {
        super(sideTop, sideLeft, sideDown, sideRight);
    }

    @Override
    public double calcArea() {
        if (this.parallelogramType == ParallelogramType.RECTANGLE) {    // Rectangle or square
            this.area = this.sideLeft * this.sideDown;
        } else if (this.parallelogramType == ParallelogramType.PARALLELOGRAM) {    // Parallelogram
            this.area = this.sideDown * this.high;
        } else this.area = super.calcArea();                            // Quadrangle

        return this.area;
    }

    @Override
    public double calcPerimeter() {
        if (this.parallelogramType == ParallelogramType.RECTANGLE || this.parallelogramType == ParallelogramType.PARALLELOGRAM) {
            this.perimeter = 2 * (this.sideLeft + this.sideDown);
        } else this.perimeter = super.calcPerimeter();
        return this.perimeter;
    }
}
