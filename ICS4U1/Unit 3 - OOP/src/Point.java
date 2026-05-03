//this is the class to create points for Enhanced Rectangle
public class Point {

    //fields
    private double x;
    private double y;

    //constructor
    Point(double x, double y) {

        this.x = x;
        this.y = y;

    }

    Point() {

        x = 0;
        y = 0;

    }

    //getters and setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //toString
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    //utility method
    //distanceTo method that has returns the distance from that point to the current point itself
    public double distanceTo(Point p2) {

        //distance formula
        //sqrt((x2-x1)^2 + (y2-y1)^2)
        return Math.sqrt(Math.pow(p2.getX() - this.getX(), 2) + Math.pow(p2.getY() - this.getY(), 2));

    }

}
