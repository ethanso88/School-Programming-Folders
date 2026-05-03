package QuadrilateralHierarchy;

public class Parallelogram extends Quadrilateral {

    //no new fields

    //Note: points are defined counter-clockwise starting in the bottom left corner
    public Parallelogram(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }

    //utility methods

    //aka the base in this case
    public double getWidth() {

        double side1 = super.getCoordinateArray()[0].distanceTo(super.getCoordinateArray()[1]);
        double side2 = super.getCoordinateArray()[1].distanceTo(super.getCoordinateArray()[2]);

        if (side1 > side2)
            return side1;
        else
            return side2;

    }

    //concrete class
    @Override
    public double getHeight() {

        Point p = new Point(super.getCoordinateArray()[0].getX(), super.getCoordinateArray()[0].getY() - super.getCoordinateArray()[3].getY());
        return super.getCoordinateArray()[0].distanceTo(p);

    }

    //concrete class
    @Override
    public double calculateArea() {

        return getWidth() * getHeight();

    }

}
