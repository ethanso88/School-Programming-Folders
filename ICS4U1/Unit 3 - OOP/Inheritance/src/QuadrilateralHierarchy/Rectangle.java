package QuadrilateralHierarchy;

public class Rectangle extends Quadrilateral {

    //no new fields

    public Rectangle(Point point1, Point point2, Point point3, Point point4) {

        super(point1,point2,point3,point4);

    }

    //utility methods
    public double getWidth() {

        double side1 = super.getCoordinateArray()[0].distanceTo(super.getCoordinateArray()[1]);
        double side2 = super.getCoordinateArray()[1].distanceTo(super.getCoordinateArray()[2]);

        if (side1 < side2)
            return side1;
        else
            return side2;

    }

    @Override
    public double getHeight() {

        double side1 = super.getCoordinateArray()[0].distanceTo(super.getCoordinateArray()[1]);
        double side2 = super.getCoordinateArray()[1].distanceTo(super.getCoordinateArray()[2]);

        if (side1 > side2)
            return side1;
        else
            return side2;

    }

    @Override
    public double calculateArea() {

        return getWidth() * getHeight();

    }


}
