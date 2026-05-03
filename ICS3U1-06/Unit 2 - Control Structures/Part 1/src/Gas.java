import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/6/2024
Course: ISC3U1-06 Mr. Fernandes
Description: Calculates the km per litre of each tank the driver inputs
and when the driver stops inputting it calculates the total km per litre of all the tanks
Major Skills: Do while loop, sentinel, running total, using an algorithm
 */

/*
//NOTE this program uses a do while loop:
do {

} while ();
this kind of loop does the thing first and only ends
if the condition on the bottom is not true
**NOTE that the regular while loop from python also exists
*/

public class Gas {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in); //input

        int kmDriven;
        int litresUsed;
        double kmPerLitre;

        int totalKmDriven = 0;
        int totalLitresUsed = 0;
        double totalKmPerLitre;

        String answer; //for the Y or N
        //note that answer is also our sentinel (controls when the loop ends)


        do {
            //Ask for the distance driven and how much gas they used
            System.out.println("Enter the distance driven and gas used");

            //Enter the km driven
            kmDriven = input.nextInt();

            //Enter the litre used
            litresUsed = input.nextInt();

            //Calculate the km per litre for the current tank

            //Divide the km per litre and show it as a decimal
            kmPerLitre = (double) kmDriven / litresUsed;

            //Show the result of the current tank (don’t forget the units)
            System.out.printf("The km per litre for the current tank is %.2fkm/L", kmPerLitre);

            //Ask the user if there are more tanks
            System.out.println("\nAre there more tanks? (Y/N)");
            answer = input.next();

            //**Add these values the total
            totalKmDriven += kmDriven;
            totalLitresUsed += litresUsed;

            //If they want to enter more tanks, then repeat Steps 1-3
        } while (answer.equals("Y")); //will keep calculating tanks when the answer equals Y

        //This is when the loop ends
        //Calculate the total km per litre for all the tanks
        totalKmPerLitre = (double) totalKmDriven/totalLitresUsed;

        //Display the result with decimals
        System.out.printf("The total km per litre is %.2fkm/L", totalKmPerLitre);

    }

}
