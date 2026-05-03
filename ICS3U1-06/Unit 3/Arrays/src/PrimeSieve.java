package arrays;

/*
(PrimeSieve) A prime number is any integer greater than 1 that is evenly divisible only by itself and 1.
“The Sieve of Eratosthenes” (see a visualization by using the link) is a classical method of finding prime numbers.
It operates as follows:

First, create a primitive type Boolean array with all elements initialized to true.

Next, start a process that when complete all array elements with prime indices (plural of index) will remain true
and all other array elements will be set to false (eventually).  Here is the process:

    Starting with array index 2, determine whether a given element is true.
    If so, loop through the remainder of the array and set to false every element whose index is a multiple of the index for the element with value true.
    Then continue the process with the next element whose value is still true.
    For array index 2, all elements beyond element 2 in the array that have indices which are multiples of 2 (indices 4, 6, 8, 10, etc.) will be set to false;
    for array index 3, all elements beyond element 3 in the array that have indices which are multiples of 3 (indices 6, 9, 12, 15, etc.) will be set to false; and so on.

When this process is complete, the array elements that are still true indicate that the index is a prime number.
These indices can be displayed.
Write an application that uses an array of 1000 elements to determine and display the prime numbers between 2 and 999.
Ignore array elements 0 and 1.
 */

public class PrimeSieve {

    //field Array
    static boolean[] primeArray = new boolean[1000];
        //1000 elements since we want prime numbers b/w 2-999

    public static void main(String[] args) {

        //1. set the prime array
        setArray();

        //2. filter the primes
        filterPrimes();

        //3. display results
        displayResults();

    }

    //method sets the array as true
    private static void setArray() {

        //default for each element in array is false

        //set all elements to true
        for (int index = 0; index < primeArray.length; index++)
            primeArray[index] = true;

        //Arrays.fill(prime, true);     // alternate way to fill Array with 'true' values

    }

    //method filters all the numbers to leave only prime numbers
    private static void filterPrimes() {

        //check numbers in list start at up to half way (after half way multiples will be greater than number of tested numbers)
        for (int index = 2; index < primeArray.length / 2; index++) {

            //check if it is true, true means prime num
            if (primeArray[index]) {

                //find not prime numbers using the multiples of prime numbers

                //first multiple is index * 2
                int multiple = index * 2;

                //set all multiples to false as they are not prime numbers
                while (multiple < primeArray.length) {

                    //set current multiple (element) to false
                    primeArray[multiple] = false;

                    //move onto next multiple
                    multiple += index;

                }
            }
        }

        //When the loop is complete all remaining indices that are true are prime numbers

    }

    //method displays the results
    private static void displayResults() {

        int count = 0;

        //1. Count and display all prime numbers
        System.out.println("The prime numbers between 2 and 999 are:");

        for (int index = 2; index < primeArray.length; index++) {

            //elements in the array that are still 'true' are prime numbers
            if (primeArray[index]) {

                System.out.println(index + " ");
                count++;

            }

        }

        //2. Display total count of prime numbers
        System.out.printf("Total prime numbers is %d", count);

    }

}
