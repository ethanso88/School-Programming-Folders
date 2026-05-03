package Model;

//represents a quantum dot nanomaterial
public class QuantumDot extends Material {

    //fields
    String solvent;
    double emissionPeak;
    String specification;

    //constructor
    public QuantumDot(String name, String company, String solvent, double emissionPeak, String specification) {
        super(name, company);
        this.solvent = solvent;
        this.emissionPeak = emissionPeak;
        this.specification = specification;
    }

    //getters and setters
    public String getSolvent() {
        return solvent;
    }

    public void setSolvent(String solvent) {
        this.solvent = solvent;
    }

    public double getEmissionPeak() {
        return emissionPeak;
    }

    public void setEmissionPeak(double emissionPeak) {
        this.emissionPeak = emissionPeak;
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
        return "QuantumDot{" +
                "solvent='" + solvent + '\'' +
                ", emissionPeak=" + emissionPeak +
                ", specification='" + specification + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
