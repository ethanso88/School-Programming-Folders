/*
(Perfect) An integer number is said to be a perfect number if its factors, including 1 (but not the number itself), sum to the number.
For example, 6 is a perfect number, because 6 = 1 + 2 + 3.
Write a method, perfect, that determines whether a parameter number is a perfect number.
Use this method in an application that determines and displays all the perfect numbers between 1 and 1000.
Display the factors of each perfect number to confirm that the number is indeed perfect.
Challenge the computing power of your computer by testing numbers much larger than 1000.
Display the results.
 */

public class Perfect {

    public static void main(String[] args) {

        int count = 0; //count number of perfect numbers

        //1. Determine which numbers b/w 1-1000 are perfect numbers
        for (int num = 1; num <= 1000; num++) {

            //1.1 Test if current number is a perfect number
            boolean perfect = perfect(num);

            //1.2 Display if the number is a perfect number
            if (perfect) {
                System.out.printf("\n%d is a perfect number\n", num);
                count++; //keep track of number of perfect numbers
            }
        }

        //2. Display number of perfect numbers
        System.out.printf("There are %d perfect numbers", count);

    }

    //This method determines if a number is a perfect number
    private static boolean perfect(int num) {

        int total = 0;

        //find all factors of the number and add the factor to a total
            //Note: we don't want the number itself to be a factor '<' not '<='
        for (int factor = 1; factor < num; factor++) {

            //if the factor is a factor display it add it to the total
            if (num % factor == 0) {
                total += factor;
            }
        }

        //determine if the number is a perfect number
        if (num == total) {
            //if the number is a perfect number display all the factors
            //repeat the loop but with display statement instead
            System.out.printf("The factors of %d are: ", num);
            for (int factor = 1; factor < num; factor++) {
                if (num % factor == 0) {
                    System.out.printf("%d ", factor);
                }
            }
            return true;
        } else
            return false;
    }

}
