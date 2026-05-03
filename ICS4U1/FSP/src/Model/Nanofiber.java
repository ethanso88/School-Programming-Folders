package Model;

//represents a nanofiber nanomaterial
public class Nanofiber extends Material {

    //fields
    double diameter;

    //constructor
    public Nanofiber(String name, String company, double diameter) {
        super(name, company);
        this.diameter = diameter;
    }

    //getters and setters
    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    //toString method
    @Override
    public String toString() {
        return "Nanofiber{" +
                "diameter=" + diameter +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
