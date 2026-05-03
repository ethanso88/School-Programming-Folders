//abstract class
public abstract class Organism {

    //fields
    String name;

    //constructor
    Organism(String name) {

        this.name = name;

    }

    //getters and setters
    public String getName() {
        return name; //doesn't need to be this.name since there is no other variable named 'name'
        //no conflict
    }

    public void setName(String name) {
        this.name = name;
    }

    //abstract toString method MUST put @OVERRIDE (replacing a previous method, the Object toString method)
    @Override
    public abstract String toString();



}
