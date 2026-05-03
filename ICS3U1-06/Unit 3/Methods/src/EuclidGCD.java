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
            int gcd;
            int num1, num2;
            int r1, r2;

            //1. get two numbers from the user
            System.out.println("Input 2 numbers to find the GCD of:");
            num1 = input.nextInt();
            num2 = input.nextInt();

            //sort the numbers by lowest and highest
            r1 = Math.min(num1, num2);
            r2 = Math.max(num1, num2);


            //2. find the GCD or GCF of the 2 numbers
            gcd = gcd(r1, r2);


            //3. display the GCD or GCF
            System.out.printf("The GCD of %d and %d is %d", r1, r2, gcd);
        }

        //This method finds the GCD of 2 numbers, numbers must be sorted by lowest and highest
        private static int gcd(int divisor, int dividend) {

            int remainder;

            //Using The Euclidean algorithm
                //https://en.wikipedia.org/wiki/Euclidean_algorithm
                //under 'Procedure' or 'Worked Example'
            do {
                //We take two numbers and find the remainder
                remainder = dividend % divisor;

                //When the remainder is zero the divisor is the GCD
                    //*step must be before reassigning of variables
                if (remainder == 0)
                    return divisor;

                //The divisor then becomes the dividend
                dividend = divisor;

                //The remainder then becomes the divisor
                divisor = remainder;

                //We repeat until the remainder becomes zero
            } while (true);

        }

    }

