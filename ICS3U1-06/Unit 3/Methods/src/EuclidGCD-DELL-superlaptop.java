import java.util.Scanner;

/*
(EuclidGCD) The greatest common divisor (GCD) of two integers is the largest integer that evenly divides each of the two numbers.
Write a method, gcd, that returns the greatest common divisor of two integers. [Hint: You might want to use Euclid’s Algorithm.
You can find information about the algorithm at https://en.wikipedia.org/wiki/Euclidean_algorithm.]
Incorporate the method into an application that reads two values from the user and displays the result.
 */

public class EuclidGCD {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double gcd;
        double num1, num2;
        double r1, r2;

        //1. get two numbers from the user
        System.out.println("Input 2 numbers to find the GCD of:");
        num1 = input.nextDouble();
        num2 = input.nextDouble();

        //sort the numbers by lowest and highest
        r1 = Math.min(num1, num2);
        r2 = Math.max(num1, num2);


        //2. find the GCD or GCF of the 2 numbers
        gcd = gcd(r1, r2);

        //3. display the GCD or GCF



    }

    private static double gcd(double r1, double r2) {

        


    }

}
