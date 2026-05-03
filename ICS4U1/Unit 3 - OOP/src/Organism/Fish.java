package Organism;

public class Fish extends Animal {

    private String group;

    Fish(String name, String foodType, String group) {

        super(name,foodType);
        this.group = group;

    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return String.format("%s, Group: %s", super.toString(), getGroup());
    }

}
