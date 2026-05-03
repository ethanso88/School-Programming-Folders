import java.util.Scanner;

/*
(CoinToss) Write an application that simulates coin tossing.
Let the program toss a coin each time the user chooses the “Toss Coin” menu option.
Count the number of times each side of the coin appears. Display the results.
The program should call a separate method, flip, that takes no arguments
and returns false for tails and true for heads.
[Note: If the program realistically simulates coin tossing,
each side of the coin should appear approximately half the time.]
Hint: Use Math.random() to create a pseudorandom number.
 */

public class CoinToss {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String answer;
        int heads = 0; //count for heads
        int tails = 0; //count for tails

        //1. Ask the user if they want to flip a coin
        System.out.println("Do you want to flip a coin? (y/n)");
        answer = input.next();

        while (answer.equalsIgnoreCase("y")) {

            //2. flip the coin
            boolean flip = flip();

            //3. Display results
            if (flip) { //Heads
                System.out.println("Heads!");
                heads++;
            } else {
                System.out.println("Tails!");
                tails++;
            }

            //4. Reprompt user for coin flip
            System.out.println("Do you want to flip a coin? (y/n)");
            answer = input.next();

            //5. repeat steps 2-4 while the user chooses 'Toss Coin'
        }

        //6. Display final results (total heads or tails)
        System.out.printf("Heads appeared %d times\n", heads);
        System.out.printf("Tails appeared %d times\n", tails);

    }

    //method determines heads or tails
    private static boolean flip() {

        double flip;

        //Math.Random generates a random number from 0.0 to 1.0
        //Multiplying it by 2 generates a random number from 0.0 to 2.0
        flip = Math.random() * 2;

        //we want an integer number of 1 or 2 though
        if (flip <= 1)
            return true;
        else //(flip > 1 || flip <= 2)
            return false;

    }

}
