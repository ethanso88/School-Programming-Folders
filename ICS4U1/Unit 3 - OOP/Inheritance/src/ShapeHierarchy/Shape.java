package ShapeHierarchy;

//need to declare this is an abstract class as we have incomplete (abstract) methods
public abstract class Shape {

    //fields (we will include things that every shape has, this is the general class)
    private double area;
    private String name;

    //constructor method
    public Shape (String name) { //only using name since the subclasses distinguish b/w 2D and 3D

        super(); //call the super constructor - Object class
        this.name = name;
    }

    //getters and setters
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //toString Method - display the contents on the console
    @Override
    public String toString() {
        return "Shape{" +
                "area=" + area +
                ", name='" + name + '\'' +
                '}';
    }

    //abstract method - concrete implementation will reside further down the hierarchy
    public abstract double calculateArea();     //(saying there is going to be this method)

}
