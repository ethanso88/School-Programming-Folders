import java.util.Arrays;

public class EnhancedRectangle extends Point {

    //fields
    private Point[] pointArray = new Point[4];

    //constructor
    public EnhancedRectangle(Point[] pointArray) {

        setPointArray(pointArray);

    }

    //getters and setters
    public Point[] getPointArray() {
        return pointArray;
    }

    public void setPointArray(Point[] pointArray) {

        //check if points in range, invalid points set to (0,0)
        for (Point p : pointArray)
            if (p.getX() < 0.0 || p.getX() > 20.0 || p.getY() < 0.0 || p.getY() > 20.0) {
                p.setX(0.0);
                p.setY(0.0);
            } else
                this.pointArray = pointArray;

    }

    //toString method
    @Override
    public String toString() {
        return "EnhancedRectangle{" +
                "coordinates=" + Arrays.toString(pointArray) +
                '}';
    }

    //utility methods

    //checks if it is a rectangle
    public boolean isRect() {

        //If the diagonals of a parallelogram are congruent it is a rectangle
        //remember it can still be a parallelogram if the check was just if opposites are equal
        if (Double.compare(pointArray[0].distanceTo(pointArray[2]), pointArray[1].distanceTo(pointArray[3])) == 0) // == 0 means true
            return true;
        else
            return false;

    }

    //find the length side of the rectangle (longest side)
    public double getLength() {

        double side1 = pointArray[0].distanceTo(pointArray[1]);
        double side2 = pointArray[1].distanceTo(pointArray[2]);

        if (side1 > side2)
            return side1;
        else
            return side2;

    }

    //find the width side of the rectangle (shortest side)
    public double getWidth() {

        double side1 = pointArray[0].distanceTo(pointArray[1]);
        double side2 = pointArray[1].distanceTo(pointArray[2]);

        if (side1 < side2)
            return side1;
        else
            return side2;

    }

    //find the perimeter of the rectangle
    public double getPerimeter() {

        return 2 * getLength() + 2 * getWidth();

    }

    //find the area of the rectangle
    public double getArea() {

        return getLength() * getWidth();

    }

    //determine if the rectangle is also a square with a predicate method (boolean method)
    public boolean isSquare() {

        if (getLength() == getWidth())
            return true;
        else
            return false;

    }

}
