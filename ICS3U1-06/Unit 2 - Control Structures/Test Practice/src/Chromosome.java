import java.util.Scanner;

public class Chromosome {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int size;           //size of arms
        int frontSpaces;    //front spaces
        int middleSpaces;   //middle spaces
        int numRows;        //number of rows

        //  1. Get arm size and check if valid
        do {
            //  1.1 Get arm size
            System.out.println("Enter the size:");
            size = input.nextInt();

            //  1.2 Repeat Step 1 until valid size
        } while (size < 1 || size > 8);

        //  2. Set start amounts for spaces and rows
        frontSpaces = 0;            //  2.1 Front spaces start at 0
        middleSpaces = size * 2;    //  2.2 Middle spaces start at twice the size
        numRows = size * 2 + 1;     //  2.3 Number of rows start at twice arms + 1 (centromere)

        //  3. Draw the shape one row at a time
        for (int rows = 1; rows <= numRows; rows++ ) {
            //  3.1 Print front spaces
            for (int spaces = 1; spaces <= frontSpaces; spaces++)
                System.out.print(" ");

            //  3.2 Print first star
            System.out.print("*");

            //  3.3 Print middle spaces
            for (int spaces = 1; spaces <= middleSpaces; spaces++)
                System.out.print(" ");

            //  3.4 Print second star and go to next line
            System.out.println("*");

            //  3.5 Make adjustments to spaces
            if (rows <= size) { //or (rows < size + 1)

                //  3.5.1 Top half - front spaces go up by 1, middle spaces go down by 2
                frontSpaces++;
                middleSpaces -= 2;

            } else {

                //  3.5.2 Bottom half - front spaces go down by 1, middle spaces go up by 2
                frontSpaces--;
                middleSpaces += 2;

            }

        }

    } //end main method

} //end class
