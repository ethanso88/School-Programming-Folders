package Model;

//represents a nanoparticle nanomaterial
public class Nanoparticle extends Material {

    //fields
    double diameter; //technically APS but I googled APS and it stands for "average particle size" which is the same as diameter
    //so I will use diameter
    String specification;
    String subtype;


    //constructor
    public Nanoparticle(String name, String company, double diameter, String specification, String subtype) {
        super(name, company);
        this.diameter = diameter;
        this.specification = specification;
        this.subtype = subtype;
    }

    //getters and setters
    public double getDiameter() { return diameter; }
    public void setDiameter(double diameter) { this.diameter = diameter; }

    public String getSpecification() { return specification; }
    public void setSpecification(String specification) { this.specification = specification; }

    public String getSubtype() { return subtype; }
    public void setSubtype(String subtype) { this.subtype = subtype; }

    //toString
    @Override
    public String toString() {
        return "Nanoparticle{" +
                "diameter=" + diameter +
                ", specification='" + specification + '\'' +
                ", subtype='" + subtype + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
