import java.util.Scanner;

public class Diamond2 {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int rows, totalStars, totalSpaces;

        //Prompt the user for an odd number of rows (1-19)
        do {
            System.out.println("Enter odd number of rows (1-19):");
            rows = input.nextInt();
        } while (rows % 2 == 0 || rows < 1 || rows > 19); //do while input is even or out of number range

        totalStars = 1; //Start with total stars = 1
        totalSpaces = rows/2; //Start with total spaces = rows/2


        //Create rows = number user entered, for the Diamond
        for (int row = 1; row <= rows; row++) {

            //Display the spaces in the row
            for (int spaces = 1; spaces <= totalSpaces; spaces++)
                System.out.print(" ");

            //Display the stars in the row
            for (int stars = 1; stars <= totalStars; stars++)
                System.out.print("*");

            //The end of the row
            System.out.println();

            //Top half (increases capacity of the stars for the top half)
            if (row <= rows/2) { //If row <= rows/2 (top half)
                //Increment total stars by 2
                totalStars += 2;

                //Decrement spaces by 1
                totalSpaces--;
            }

            //Bottom half (decreases capacity of the stars for the bottom half)
            else {
                //Decrement total stars by 2
                totalStars -= 2;

                //Increment spaces by 1
                totalSpaces++;
            }
        }
    }

}
