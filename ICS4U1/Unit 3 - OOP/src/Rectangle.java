/*
(Rectangle Class) Create a class Rectangle.
The class has attributes length and width, each of which defaults to 1.
It has methods that calculate the perimeter and the area of the rectangle.
It has set and get methods for both length and width.
The set methods should verify that length and width are each floating-point
numbers larger than 0.0 and less than 20.0.
Write a program to test class Rectangle.
 */

/*
Remember how to code a template class

1) fields
2) constructor method
3) getters and setters
4) toString
*5) utility methods (*optional)
 */

//Template Class
public class Rectangle extends Object {
    //implicitly already extends Object, don't need to explicitly extend it

    //fields, attributes, characteristics, properties, instance variables
    private double length;
    private double width;

    //constructor method
    //lowercase for this method will NOT make it a constructor method
    //allowed to have a different name for the parameters than the field
    public Rectangle(double length, double width) {
        //explicit super call, already implicitly calls super
        super();    //calling the super class constructor extending from (Object class)

        //associate the fields with the parameters
        //*call set methods since we have validation code
        setLength(length);
        setWidth(width);
    }

    //getters (accessors) and setters (mutators)
    public double getLength() {
        return length;
    }

    public void setLength(double length) {

        //validation code
        if (length <= 0.0 || length >= 20.0) {
            System.out.println("Invalid length - set to 1.0");
            this.length = 1.0;
        } else
            this.length = length;   //object variable = parameter variable
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {

        //validation code
        if (width <= 0.0 || width >= 20.0) {
            System.out.println("Invalid width - set to 1.0");
            this.width = 1.0;
        } else
            this.width = width;
    }

    //used to display the object's properties on the console
    @Override   //preprocessor command, override the default Object classes toString method
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    //utility methods
    public double getPerimeter() {

        return 2 * (length + width);

    }

    public double getArea() {

        return length * width;

    }

}
