
//template class
public class Date {

    //make the words of each month accessible by number
    private static final String[] monthArray = {"January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"};

    private static final int[] daysArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    //fields
    private int month;
    private int day;
    private int year;

    //first constructor for a date in the form: MM/DD/YYYY
    Date(int month, int day, int year) {

        this.month = month;
        this.day = day;
        this.year = year;

    }

    //second constructor for a date like: June 14, 1992
    Date(String month, int day, int year) {

        //initialize the month
        for (int index = 0; index < monthArray.length; index++) {

            if (monthArray[index].equals(month)) {
                this.month = index + 1;
                break;
            }

        }

        this.day = day;
        this.year = year;

    }

    //third constructor for a date in the form: DDD YYYY
    Date(int days, int year) {

        //separate days into months and days
        for (int index = 0; index < daysArray.length; index++) {

            if (days > daysArray[index]) {
                days = days - daysArray[index];
            }
            else {
                day = days;
                month = index + 1;
                break;
            }
        }

        this.year = year;

    }

    //getters and setters
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //toString
    @Override
    public String toString() {
        return "Date{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }


    //utility methods

    //this method gets the day number (converts to DDD) based on the day and month
    public int getDayNumber(int d, int m) {

        int days = d; //DDD days

        for (int index = 0; index < m; index++) {

            days += daysArray[m];

        }

        //return the converted days (DDD)
        return days;

    }

    //displayDate1 would show the date in the format 3/27/2025.
    public void displayDate1() {

        System.out.printf("%d/%d/%d\n", getMonth(), getDay(), getYear());

    }

    //displayDate2 would show the date in the format June 14, 1992
    public void displayDate2() {

        System.out.printf("%s %d, %d\n", monthArray[getMonth() - 1], getDay(), getYear());

    }

    //displayDate3 would show the date in the format 123 2022
    public void displayDate3() {

        System.out.printf("%d %d\n", getDayNumber(getDay(), getMonth()), getYear());

    }


}
