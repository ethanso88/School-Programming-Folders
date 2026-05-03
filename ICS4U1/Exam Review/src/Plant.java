public class Plant extends Organism {

    //fields
    int height;

    //constructor
    Plant(String name, int height) {
        super(name);
        this.height = height;
    }

    //getters and setters
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0)
            this.height = height;
        else
            this.height = 0;
    }

    //toString method
    @Override //override super's toString method
    public String toString() {
        return String.format("[%s] name = %s, height = %d", //STRING.FORMAT
                this.getClass().getSimpleName(),
                this.getName(),
                this.getHeight());
    }

}
