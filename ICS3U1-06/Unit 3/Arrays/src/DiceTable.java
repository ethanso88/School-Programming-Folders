package arrays;

import java.util.Random;
import java.util.Scanner;

/*
(DiceTable) Write an application to simulate the rolling of two dice.
The application should create two Random objects (as opposed to using Math.random( )),
one to simulate rolling the first die and the other  to simulate rolling the second die.
The sum of the two values should then be calculated.
Each die can show an integer value from 1 to 6, so the sum of the values will range from 2 to 12,
with 7 being the most frequent sum, and 2 and 12 the least frequent.
Your application should ask the user how many times to roll the dice
and then it should tally the number of times each possible sum appears, storing the results in an array.
Next, display the final results in a table format with headings for the columns (Total and Number).
To check your work, determine whether the totals are reasonable
(e.g., there are six ways to roll a 7, so approximately one-sixth of the rolls should be 7).
 */

public class DiceTable {

    //declare your array as a static ‘field’ (global variable)
        //so it can be used in all methods
    static int[] diceTallyArray = new int[13];
        //size is 13 because the indexes will be from 0 to 12
        //12 is max sum size, 2 is min sum size, will skip index 0 and 1


    public static void main(String[] args) {

        //1. get the number of rolls
        int numRolls = getRolls();

        //2. roll the dice
        rollDice(numRolls);

        //3. display the table
        displayTable();

    }

    //method gets number of rolls
    private static int getRolls() {

        Scanner input = new Scanner(System.in);

        System.out.println("How many rolls?");
        int numRolls = input.nextInt();

        return numRolls;

    }

    //method rolls the dice and counts the # of times each sum was rolled
    private static void rollDice(int numRolls) {

        //make a random object to make a random number for the dice (instead of Math.Random())
        Random rand = new Random();

        for (int times = 1; times <= numRolls; times++) {

            int die1 = rand.nextInt(6) + 1; //generate dice 1
            int die2 = rand.nextInt(6) + 1; //generate dice 2

            //add 1 to the correlating index of the sum
            diceTallyArray[die1 + die2]++;
                //++ increases the count, # of times that sum was rolled

        }

    }

    //method displays the table
    private static void displayTable() {

        System.out.printf("%s\t\t%s\n", "Number", "Total");

        for (int index = 2; index < diceTallyArray.length; index++) {

            System.out.printf("%d\t\t\t%d\n", index, diceTallyArray[index]);

        }

    }

}
