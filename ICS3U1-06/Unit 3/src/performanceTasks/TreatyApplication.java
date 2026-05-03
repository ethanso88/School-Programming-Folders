package performanceTasks;

/*
Ethan So
4/24/2024
 */

import java.util.Scanner;

//a class that builds the treaty list and runs the application
public class TreatyApplication {

    //Field
    private static Treaty[] treatyArray = new Treaty[7];
    
    //this method runs the application and calls the various methods of the program
    public static void main(String[] args) {

        fillArray();
        displayTitle();
        displayArray();
        int year = getYear();
        displayNumTreatyGroups(year);

    }

    //this method fills the Treaty array with data
    private static void fillArray() {

        treatyArray[0] = new Treaty("Douglas Treaties", 14, 1850, 1854);
        treatyArray[1] = new Treaty("Numbered Treaties", 11, 1871, 1921);
        treatyArray[2] = new Treaty("Robinson Treaties", 2, 1850, 1850);
        treatyArray[3] = new Treaty("Williams Treaties", 2, 1923, 1923);
        treatyArray[4] = new Treaty("Upper Canada Land Surrenders", 30, 1781, 1862);
        treatyArray[5] = new Treaty("Peace & Neutrality Treaties", 3, 1701, 1760);
        treatyArray[6] = new Treaty("Maritime Peace and Friendship Treaties", 8, 1725, 1779);

    }

    //this method displays a Title on the console for the application
    private static void displayTitle() {

        System.out.println("HISTORIC TREATIES IN CANADA");
        System.out.println("===========================");

    }

    //this method displays the objects in the Treaty array in ascending order based on number of treaties
    private static void displayArray() {

        for (int index = 0; index < treatyArray.length; index++)
            System.out.println(treatyArray[index].toString());

    }

    //this method is used to prompt the user for a year and returns its value
    private static int getYear() {

        Scanner input = new Scanner(System.in);
        int year;

        //get year for treaties
        do {
            System.out.println("Enter the year you wish to see?");
            year = input.nextInt();

            //re-prompt invalid entries
        } while (year <= 0);

        return year;

    }

    //displays the number of treaty groups that were signed during the given year (see sample)
    private static void displayNumTreatyGroups(int year) {

        //count treaty groups
        int count = 0;

        //find number of treaty groups with inputted year in their signing range
        for (int index = 0; index < treatyArray.length; index++) {

            if (year >= treatyArray[index].getStartYear() && year <= treatyArray[index].getEndYear())
                count++;

        }

        if (count > 0)
            System.out.printf("%d treaty group(s) were signed during %d.\n", count, year);
        else
            System.out.println("Sorry no matching treaty groups");

    }

}
