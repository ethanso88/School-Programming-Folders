package QuadrilateralHierarchy;

public class Trapezoid extends Quadrilateral {

    //no new specific fields

    //Note: points are defined counter-clockwise starting in the bottom left corner
    public Trapezoid(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }

    //don't need getters, setters or toString since no new fields

    //utility methods
    @Override
    public double getHeight() {

        Point p = new Point(super.getCoordinateArray()[0].getX(), super.getCoordinateArray()[0].getY() - super.getCoordinateArray()[3].getY());
        return super.getCoordinateArray()[0].distanceTo(p);

    }

    //concrete method
    @Override
    public double calculateArea() {

        double a = super.getCoordinateArray()[0].distanceTo(super.getCoordinateArray()[1]);

        double b = super.getCoordinateArray()[3].distanceTo(super.getCoordinateArray()[2]);

        return (a+b)/2 * getHeight();

    }

}
