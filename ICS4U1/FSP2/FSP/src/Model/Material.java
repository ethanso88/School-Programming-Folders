package Model;

// This is the java class to represent the Nano Material that is searched for in the project
public abstract class Material {

    // Fields (The description of each material)
    // Its name
    protected String name;
    // Its producer
    protected String company;

    // Constructor (country removed)
    public Material(String name, String company) {
        this.name = name;
        this.company = company;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // toString method
    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
