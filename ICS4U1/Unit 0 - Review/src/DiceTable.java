import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DiceTable {

    static ArrayList<Integer> diceTally = new ArrayList<>();

    public static void main(String[] args) {

        //get the number of rolls
        int numRolls = getNumberOfRolls();

        //initialize array
        initializeList();

        //roll the dice
        rollDice(numRolls);

        //make display table
        displayTable();

    }

    //
    private static int getNumberOfRolls() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter how many times do you want to roll the dice?");

        return input.nextInt();
    }

    //
    private static void initializeList() {

        int diceCount = 13;

        for (int count = 0; count < diceCount; count++) {

            //set each element to 0
            diceTally.add(0);
        }

    }

    //
    private static void rollDice(int numRolls) {

        //Random object for the dice roll
        Random dice = new Random();

        //sum of the dice
        int diceTotal;

        for (int count = 0; count < numRolls; count++) {

            //roll two dice and add the sum each time. min 2, max 12
            diceTotal = (dice.nextInt(6) + 1) + (dice.nextInt(6) + 1);

            //tally the count in the array
            diceTally.set(diceTotal, diceTally.get(diceTotal) + 1);

        }

    }

    //
    private static void displayTable() {

        System.out.println("DiceResults\nTotal\tNumber");

        for (int count = 2; count < diceTally.size(); count++) {

            System.out.printf("%d\t%d\n", count, diceTally.get(count));

        }


    }

}
