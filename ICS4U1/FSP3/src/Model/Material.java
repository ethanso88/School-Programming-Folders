package Model;

/**
 * Material.java
 * 
 * Abstract base class for all nanoscale materials in the database.
 * Stores the common fields: name and company (producer).
 * All specific material types (Nanotube, Nanoparticle, etc.) extend this class.
 * 
 * Written for ICS4U1, Ontario Grade 12 Computer Science.
 */
public abstract class Material {

    // Fields: description of each material
    protected String name;      // The name of the material
    protected String company;   // The producer or company

    /**
     * Constructor for Material.
     * @param name    The name of the material.
     * @param company The producer/company.
     */
    public Material(String name, String company) {
        this.name = name;
        this.company = company;
    }

    // --- Getters and setters ---

    /** @return the name of the material */
    public String getName() { return name; }

    /** @param name the new name for the material */
    public void setName(String name) { this.name = name; }

    /** @return the company/producer */
    public String getCompany() { return company; }

    /** @param company the new company/producer */
    public void setCompany(String company) { this.company = company; }

    /**
     * Returns a string representation of the material.
     * @return a string with name and company.
     */
    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
