package performanceTasksMorePractice;

//Ethan So
//4/25/2024

//a template class to ‘build’ anime characters
public class AnimeCharacter2 {

    //fields
    private String name;
    private String series;
    private int firstAppearance;

    //constructor method
    public AnimeCharacter2(String name, String series, int firstAppearance) {

        //doesn't require validation code
        this.name = name;
        this.series = series;

        //call set method since requires validation code
        setFirstAppearance(firstAppearance);

    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(int firstAppearance) {

        //validation code
        if (firstAppearance >= 0 && firstAppearance <= 2024)
            this.firstAppearance = firstAppearance;
        else
            this.firstAppearance = 0;   //default value
    }

    //toString method to display object to the console
    @Override
    public String toString() {
        return "AnimeCharacter2{" +
                "name=" + name +
                ", series=" + series +
                ", firstAppearance=" + firstAppearance +
                '}';
    }

}
