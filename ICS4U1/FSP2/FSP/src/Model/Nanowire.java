package Model;

public class Nanowire extends Material {

    //fields
    double diameter;

    //constructor
    public Nanowire(String name, String company, double diameter) {
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

    //toString
    @Override
    public String toString() {
        return "Nanowire{" +
                "diameter=" + diameter +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
