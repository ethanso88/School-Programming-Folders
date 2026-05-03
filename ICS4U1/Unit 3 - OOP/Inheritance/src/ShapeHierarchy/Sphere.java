package ShapeHierarchy;

public class Sphere extends ThreeDimensionalShape {

    //fields
    private double radius;
    //(when determining the fields we "factor out" the common fields in previous classes)

    //constructor
    public Sphere(double radius) {

        super("Sphere");
        this.radius = radius;

    }

    //getters and setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //toString method - display the object to console
    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                '}';
    }

    //utility methods
    @Override
    public double calculateArea() {

        return 4 * Math.PI * Math.pow(radius, 2);

    }

    @Override
    public double calculateVolume() {

        return (double) 4/3 * Math.PI * Math.pow(radius, 3);
        //need to cast as 4/3 are int
    }

}
