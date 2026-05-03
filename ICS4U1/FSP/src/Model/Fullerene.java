package Model;

//represents a fullerene nanomaterial
public class Fullerene extends Material {

    //fields
    double atoms;
    String specification;


    //constructor
    public Fullerene(String name, String company, double atoms, String specification) {
        super(name, company);
        this.atoms = atoms;
        this.specification = specification;
    }

    //getters and setters
    public double getAtoms() {
        return atoms;
    }

    public void setAtoms(double atoms) {
        this.atoms = atoms;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    //toString
    @Override
    public String toString() {
        return "Fullerene{" +
                "atoms=" + atoms +
                ", specification='" + specification + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
