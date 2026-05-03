package performanceTasks;

/*
* REMEMBER TO PUT NAME AND DATE *
Ethan So
4/23/2024
 */

//a template class to ‘build’ anime characters - COMMENT COPIED FROM THE DOC
public class AnimeCharacter {

    //fields
    private String name;
    private String series;
    private int firstAppearance;

    //constructor method
    public AnimeCharacter(String name, String series, int firstAppearance) {
        super();

        //no validation code, directly set the fields
        this.name = name;
        this.series = series;

        //call the set method since validation code
        setFirstAppearance(firstAppearance);
    }

    //get and set methods
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
            this.firstAppearance = 1;   //default value
    }

    //toString() method
        //display the object to the console
    @Override
    public String toString() {
        return "AnimeCharacter{" +
                "name='" + name + '\'' +
                ", series='" + series + '\'' +
                ", firstAppearance=" + firstAppearance +
                '}';
    }
}
