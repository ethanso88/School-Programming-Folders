package Organism;

public class Plant extends Organism implements Growable{

    private int height;
    private boolean type;

    Plant(String name, int height, boolean type) {

        super(name);
        setHeight(height);
        this.type = type;

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 1)
            this.height = 1;
        else
            this.height = height;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public int growthRate() {

        if (type && height < 2)
            return 10;
        else if (type && height > 2)
            return 5;
        else
            return 2;

    }

    @Override
    public String toString() {
        return String.format("%s, Flowering: %b, Height: %d", super.toString(), isType(), getHeight());
    }

}
