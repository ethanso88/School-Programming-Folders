package Organism;

public abstract class Animal extends Organism {

    private String foodtype;

    Animal(String name, String foodtype) {

        super(name);
        this.foodtype = foodtype;

    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    @Override
    public String toString() {
        return String.format("%s, Food type: %s", super.toString(), getFoodtype());
    }

}
