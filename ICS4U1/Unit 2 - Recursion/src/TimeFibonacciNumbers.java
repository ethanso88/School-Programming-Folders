import java.util.Scanner;

public class TimeFibonacciNumbers {

    //global variable
    static int calls = 0;

    public static void main(String[] args) {

        //NOTE this class has DEEP RECURSION (TAKES A LONG TIME)

        //take input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the nth digit for Fibonacci: ");
        int num = input.nextInt();

        //start the timer
        double start = System.nanoTime();
        //run the program
        int sum = fib(num);
        //end the timer
        double end = System.nanoTime();

        //calculate the total time taken
        double totalTime = end - start;

        //display info
        System.out.println("Time Elapsed: " + totalTime);
        System.out.printf("Total calls: %d \n", calls);
        System.out.printf("Sum: %d \n", sum);

    }

    private static int fib(int currentTerm) {

        //increment num of calls
        calls++;

        //base case f(0) = 0, f(1) = 1
        if (currentTerm == 0 || currentTerm == 1) {

            return currentTerm;

        }

        //otherwise add up the previous 2 terms (recursive calls)
        else {

            return fib(currentTerm - 1) + fib(currentTerm - 2);

        }





    }
}
