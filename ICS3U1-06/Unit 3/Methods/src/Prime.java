/*
LESSON TO BE LEARNED (*original code was way longer)
- don't make extra work for yourself just leave 1 out of the numbers tested
  because you know it is not a prime number already
- read the question carefully, in this case time could've been saved by calculating the limit
- don't make even more work for yourself, only test for factors b/w 2 and the limit
  as if they are factors it automatically means its not a prime number.
  DON'T KEEP TRACK OF ITS DIVISIBLE BY 1 or ITSELF just creates extra work
 */

/*
(Prime) A positive integer is said to be prime if it is divisible by only 1 and itself.
For example, 2, 3, 5 and 7 are prime, but 4, 6, 8 and 9 are not.
Note, the number 1, by definition, is not prime
- Write a method, isPrime, that determines whether a number is prime.
- Use this method in an application that determines and displays all the prime numbers less than 10,000.
  How many numbers up to 10,000 do you have to test to ensure that you have found all the primes?
- Initially, you might think that n/2 is the upper limit for which you must test to see whether a number is prime,
 but you need only go as high as the square root of n. Why? Rewrite the program, and run it both ways.
 */

public class Prime {

    public static void main(String[] args) {

        int count = 0; //count number of prime numbers

        //1. Determine which numbers b/w 2-10000 are prime numbers
            //'1' is not a prime number
        for (int num = 2; num < 10000; num++) {

            //1.1 Determine if current number is a prime number
            boolean prime = prime(num);

            //1.2 Display and add it to a count if it is
            if (prime) { //if prime is true
                System.out.printf("%d is a prime number\n", num);
                count++;
            }
        }

        //2. Display total number of prime numbers
        System.out.printf("There are %d prime numbers", count);

    }

    //Method determines if the number is a prime number or not
    private static boolean prime(int num) {

        //the limit is the numbers you need to test up to if they are factors or not
        //there will be a point when the numbers are so big that there is not point to test them
            //such as is 27 a factor of 28
        int limit = (int) Math.sqrt(num);

        //find all factors of the number (that are not 1 and itself) to test if the number is prime
        for (int factor = 2; factor <= limit; factor++) {

            //Test for a factor
            if (num % factor == 0) {
                //if there is a factor it is not a prime number
                return false;
            }
        }

        //if the loop ends without returning false that means the only factors are 1 and itself
            //meaning it's a prime number
        return true;

    }

}
