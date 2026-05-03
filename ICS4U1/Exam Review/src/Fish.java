public class Fish extends Organism implements Animal {

    //field
    int speed;

    //constructor
    Fish(String name, int speed) {
        super(name);
        this.speed = speed;
    }

    //set and get methods
    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        if (speed < 0)
            this.speed = 0;
        else
            this.speed = speed;
    }

    //toString method
    @Override
    public String toString() {
        return String.format("[%s] name = %s, speed = %d",
                getClass().getSimpleName(),
                super.getName(),
                getSpeed());
    }

}
