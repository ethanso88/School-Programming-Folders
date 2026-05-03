package ShapeHierarchy;

public class Circle extends TwoDimensionalShape {

    //fields (new geometrical properties)
    private double radius;

    //constructor
    public Circle(double radius) {

        super("Circle");
        setRadius(radius); //since there is validation code this time

    }

    //getters and setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        //validation code
        if (radius < 0)
            this.radius = 1.0; //default value
        else
            this.radius = radius;


        //could also be the opposite:
        //if (radius > 0.0)
        //  this.radius = radius;
        //else
        //  this.radius = 1.0;
    }

    //to display on the console
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    //utility method
    @Override //for communication, we are overriding the abstract method earlier
    public double calculateArea() {

        return Math.PI * Math.pow(radius,2);

    }

}
