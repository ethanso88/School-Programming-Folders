public class Date {

    //Fields
    private int month;
    private int day;
    private int year;


    //constructor method
    public Date(int month, int day, int year) {

        //requires validation code
        //will call set method
        setMonth(month);
        setYear(year);
        setDay(day);    //call setDay() after since it calls upon values of from month and year
                        //otherwise if setYear() is after setDay() the getYear() called will always == 0

    }


    //Getters and Setters
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        //check for valid month
        if (month >= 1 && month <= 12)
            this.month = month;
        else
            this.month = 1; //default value
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {

        //check for invalid day (ignore leap year)
        if (day < 1                                                 //day cannot be 0 or less
                || ((month == 4 || month ==  6 || month == 9 || month == 11) && day > 30) //day cannot be 31 or more for certain months
                || (month == 2 && day > 28)                         //day cannot be 29 or more for Feb
                || day > 31)                                        //day cannot be 32 or more for the rest of the months
            this.day = 1;   //default value
        else
            this.day = day;

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        //check for valid year
        if (year >= 1970 && year <= 2024)
            this.year = year;
        else
            this.year = 1970;   //default value - Java 'epoch' year
    }


    @Override
    public String toString() {
        return "Date{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }


    //Utility method that displays the date
    public void displayDate() {

        //displays the month, day and year separated by forward slashes (/)
        System.out.printf("%d/%d/%d\n", getMonth(), getDay(), getYear());

    }

}
