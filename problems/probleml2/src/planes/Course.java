package planes;

import planes.enums.Direction;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Course {
    private Direction direction;
    private double northCourse;
    private double directionCourse;

    public Course(double northCourse) {
        if (northCourse >= 360) {
            this.northCourse = northCourse - ((int) (northCourse / northCourse) * northCourse);
        }
        this.northCourse = northCourse;
        calcDirection();
    }

    private void calcDirection() {
        if (northCourse > 337.5 || northCourse <= 22.5) {
            direction = Direction.NORTH;
            if (northCourse > 337.5)
                directionCourse = 337.5 - 360;
            else directionCourse = northCourse;
        } else if (northCourse <= 67.5) {
            direction = Direction.NORTH_EAST;
            directionCourse = northCourse - 45;
        } else if (northCourse <= 112.5) {
            direction = Direction.EAST;
            directionCourse = northCourse - 90;
        } else if (northCourse <= 157.5) {
            direction = Direction.SOUTH_EAST;
            directionCourse = northCourse - 135;
        } else if (northCourse <= 202.5) {
            direction = Direction.SOUTH;
            directionCourse = northCourse - 180;
        } else if (northCourse <= 247.5) {
            direction = Direction.SOUTH_WEST;
            directionCourse = northCourse - 225;
        } else if (northCourse <= 292.5) {
            direction = Direction.WEST;
            directionCourse = northCourse - 270;
        } else if (northCourse <= 337.5) {
            direction = Direction.NORTH_WEST;
            directionCourse = northCourse - 315;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public double getNorthCourse() {
        return northCourse;
    }

    public double getDirectionCourse() {
        return directionCourse;
    }

    public void setNorthCourse(double northCourse) {
        if (northCourse >= 360) {
            this.northCourse = northCourse - ((int) (northCourse / northCourse) * northCourse);
        }
        this.northCourse = northCourse;
        calcDirection();
    }

    @Override
    public String toString() {
        return "Course{" +
                "northCourse =\t" + northCourse +
                "\ndirection =\t" + direction +
                "\ndirectionCourse =\t" + directionCourse +
                '}';
    }
}
