package Model;

public class Nanotube extends Material {

    //fields
    String subtype;
    double diameter;
    String specification;
    String configuration; // <-- new field


    //constructor
    public Nanotube(String name, String company, double diameter, String specification, String subtype, String configuration) {
        super(name, company);
        this.diameter = diameter;
        this.specification = specification;
        this.subtype = subtype;
        this.configuration = configuration;
    }

    //getter and setter
    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    //toString
    @Override
    public String toString() {
        return "Nanotube{" +
                "diameter=" + diameter +
                ", specification='" + specification + '\'' +
                ", subtype='" + subtype + '\'' +
                ", configuration='" + configuration + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
