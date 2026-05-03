public class DateTest {

    public static void main(String[] args) {

        //create 3 date objects using different constructors
        Date d1 = new Date(3,27,2025);
        Date d2 = new Date("June",27,2025);
        Date d3 = new Date(32,2025);

        //display each date for the 3 objects
        d1.displayDate1();
        d1.displayDate2();
        d1.displayDate3();

        System.out.println();

        d2.displayDate1();
        d2.displayDate2();
        d2.displayDate3();

        System.out.println();

        d3.displayDate1();
        d3.displayDate2();
        d3.displayDate3();

    }

}
