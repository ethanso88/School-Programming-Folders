package Model;

import java.util.Arrays;

public class Card {

    //fields
    String beantype; //e.g., "coffee", "chili", etc.
    int totalBeanCount; //total number of beans of that type
    int[] beanometer; //how many coins you earn for sets for that bean type (based on Bohnanza rules)
    String imagePath; //for GUI image
    int id; //optional for unique identification (for deck order perhaps?)

    //constructor
    public Card(String beantype, int totalBeanCount, int[] beanometer, String imagePath, int id) {
        this.beantype = beantype;
        this.beanometer = beanometer;
        this.totalBeanCount = totalBeanCount;
        this.imagePath = imagePath;
        this.id = id;
    }

    //getters and setters
    public String getBeantype() {
        return beantype;
    }

    public void setBeantype(String beantype) {
        this.beantype = beantype;
    }

    public int getTotalBeanCount() {
        return totalBeanCount;
    }

    public void setTotalBeanCount(int totalBeanCount) {
        this.totalBeanCount = totalBeanCount;
    }

    public int[] getBeanometer() {
        return beanometer;
    }

    public void setBeanometer(int[] beanometer) {
        this.beanometer = beanometer;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //toString method
    @Override
    public String toString() {
        return "Card{" +
                "beantype='" + beantype + '\'' +
                ", totalBeanCount=" + totalBeanCount +
                ", beanometer=" + Arrays.toString(beanometer) +
                ", imagePath='" + imagePath + '\'' +
                ", id=" + id +
                '}';
    }


}
