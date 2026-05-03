package QuadrilateralHierarchy;

import java.util.Arrays;

public abstract class Quadrilateral {

    //general fields
    private Point[] coordinateArray = new Point[4];

    //Note: points are defined counter-clockwise starting in the bottom left corner
    Quadrilateral(Point point1, Point point2, Point point3, Point point4) {

        coordinateArray[0] = point1;
        coordinateArray[1] = point2;
        coordinateArray[2] = point3;
        coordinateArray[3] = point4;
    }

    //getters and setters
    public Point[] getCoordinateArray() {
        return coordinateArray;
    }

    public void setCoordinateArray(Point[] coordinateArray) {
        this.coordinateArray = coordinateArray;
    }

    //display object to console
    @Override
    public String toString() {
        return "Quadrilateral{" +
                "coordinateArray=" + Arrays.toString(coordinateArray) +
                '}';
    }

    //utility methods
    public abstract double calculateArea();
    public abstract double getHeight();



}
