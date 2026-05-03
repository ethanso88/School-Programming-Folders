import java.util.Scanner;

public class FactorialTest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //prompt user for a factorial
        System.out.println("Enter the number of n for n! :");
        int num = input.nextInt();

        int factorial = factorial(num);
        System.out.printf("The result of %d! is %d", num, factorial);


    }

    public static int factorial(int num) {

        //create base case
        if (num == 0)
            return 1;
        //recursive call
        //ex factorial 1! = 1 * 0!
        //factorial n! = n * (n-1)!
        else
            return num * factorial(num - 1);

            //return num * factorial(--num); //pre-decrement - works as intended since it decreases before it is passed in
            //return num * factorial(num--); //post-decrement - causes 'infinite recursion', since it only decreases after it is passed, causes 'stack overflow'

    }

}
