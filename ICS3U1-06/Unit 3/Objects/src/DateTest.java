public class DateTest {

    public static void main(String[] args) {

        //create objects
        Date date1 = new Date(3, 31, 2024);
        Date date2 = new Date(2, 31, 2024);
        Date date3 = new Date(20, 300, -100);
        Date date4 = new Date(2, 29, 2020);
        Date date5 = new Date(-10, 0, 21);

        //Display Date
        System.out.println("Note: '1' or '1970' means set to default since inputted date cannot be set");
        date1.displayDate();
        date2.displayDate();
        date3.displayDate();
        date4.displayDate();
        date5.displayDate();

    }

}
