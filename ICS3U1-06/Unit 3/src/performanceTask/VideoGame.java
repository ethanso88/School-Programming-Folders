package performanceTask;

//Ethan So
//4/26/2024

//a template class to ‘build’ video game
public class VideoGame {

    //fields
    private String gameTitle;
    private String developer;
    private int year;
    private double viewers;


    //constructor method
    public VideoGame(String gameTitle, String developer, int year, double viewers) {

        //do not need validation code and get directly implemented
        this.gameTitle = gameTitle;
        this.developer = developer;

        //call set method since it requires validation code
        setYear(year);
        setViewers(viewers);
    }

    //getters and setters
    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        //validation code
        if (year >= 0 && year <= 2024)
            this.year = year;
        else
            this.year = 0;  //default value
    }

    public double getViewers() {
        return viewers;
    }

    public void setViewers(double viewers) {

        //validation code
        if (viewers < 0)
            this.viewers = 0;   //default value
        else
            this.viewers = viewers;
    }


    //toString method to directly display object to the console
    @Override
    public String toString() {
        return "VideoGame [" +
                "gameTitle='" + gameTitle + '\'' +
                ", developer='" + developer + '\'' +
                ", year=" + year +
                ", viewers=" + viewers +
                ']';
    }
}
