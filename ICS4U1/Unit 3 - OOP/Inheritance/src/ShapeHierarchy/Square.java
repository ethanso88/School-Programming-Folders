package ShapeHierarchy;

public class Square extends TwoDimensionalShape {

    //fields
    private double side;

    //constructor
    Square(double side) {

        super("Square");
        this.side = side;

    }

    //getters and setters
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    //display object to console
    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }

    //utility methods
    @Override
    public double calculateArea() {

        return Math.pow(side,2);

    }

}
