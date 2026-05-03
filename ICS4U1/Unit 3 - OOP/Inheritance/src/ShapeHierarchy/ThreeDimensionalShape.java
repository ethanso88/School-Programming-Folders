package ShapeHierarchy;

public abstract class ThreeDimensionalShape extends Shape {

    //field
    private double volume;

    //constructor
    public ThreeDimensionalShape(String name) {

        super(name); //name will be passed to the super constructor method
                    //the higher method in this case is the Shape constructor method that 'name' is passed to

    }

    //getters and setters
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    //abstract utility method
    public abstract double calculateVolume();

}
