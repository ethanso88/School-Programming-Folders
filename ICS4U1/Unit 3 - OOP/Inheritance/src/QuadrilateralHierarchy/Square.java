package QuadrilateralHierarchy;

public class Square extends Quadrilateral {

    //no new fields

    //constructor
    public Square(Point point1, Point point2, Point point3, Point point4) {

        super(point1,point2,point3,point4);

    }

    //utility methods

    @Override
    public double getHeight() {

        return super.getCoordinateArray()[0].distanceTo(super.getCoordinateArray()[1]);

    }

    @Override
    public double calculateArea() {

        return getHeight() * getHeight();

    }

}
