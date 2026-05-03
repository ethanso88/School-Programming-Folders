package ShapeHierarchy;

//NOT abstract because it is a concrete method (I believe we complete the abstract methods in this method)
public class Cube extends ThreeDimensionalShape {

    //field (new geometrical properties)
    private double side;

    //constructor
    public Cube(double side) {

        super("Cube"); //pass the name up to the super constructor for processing
        this.side = side;

    }

    //getters and setters
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    //toString method
    @Override
    public String toString() {
        return "Cube{" +
                "side=" + side +
                '}';
    }

    //These are the concrete implementations of our abstract methods
    //(we are actually coding the unfinished incomplete methods)
    @Override
    public double calculateArea() {
        return 6 * side * side; //surface area
    }

    @Override
    public double calculateVolume() {
        return Math.pow(side,3);
    }

}
