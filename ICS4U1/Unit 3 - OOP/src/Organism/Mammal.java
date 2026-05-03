package Organism;

public class Mammal extends Animal {

    private int numLegs;

    Mammal(String name, String foodType, int numLegs) {

        super(name,foodType);
        setNumLegs(numLegs);

    }

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        if (numLegs < 2)
            this.numLegs = 2;
        else
            this.numLegs = numLegs;
    }

    @Override
    public String toString() {
        return String.format("%s, Number of Legs: %d", super.toString(), getNumLegs());
    }

}
