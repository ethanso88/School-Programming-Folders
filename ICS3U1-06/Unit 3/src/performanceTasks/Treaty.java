package performanceTasks;

/*
Ethan So
4/24/2024
 */

//a template class to ‘build’ treaties
public class Treaty {

    //fields
    private String name;
    private int number;
    private int startYear;
    private int endYear;

    //constructor method
    public Treaty(String name, int number, int startYear, int endYear) {
        this.name = name;

        //since these are validated
        setNumber(number);
        setStartYear(startYear);
        setEndYear(endYear);
        setStartYear(startYear); //need to call it again because startYear uses the result from setEndYear

    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {

        //validation code
        if (number > 0)
            this.number = number;
        else
            this.number = 1;    //default value

    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {

        //validation code
        if (startYear > 0  && startYear <= endYear)
            this.startYear = startYear;
        else
            this.startYear = 0;     //default value

    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {

        //validation code
        if (endYear > 0 && endYear >= startYear)
            this.endYear = endYear;
        else
            this.endYear = 0;   //default value

    }

    //toString method to display the object to the console
    @Override
    public String toString() {
        return "Treaty{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }

}
