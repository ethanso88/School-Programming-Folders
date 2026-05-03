package Model;

public class Graphene extends Material {

    // fields
    double thickness;
    String specification;

    // constructor (no country)
    public Graphene(String name, String company, double thickness, String specification) {
        super(name, company);
        this.thickness = thickness;
        this.specification = specification;
    }

    // getters and setters
    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    // toString
    @Override
    public String toString() {
        return "Graphene{" +
                "thickness=" + thickness +
                ", specification='" + specification + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
