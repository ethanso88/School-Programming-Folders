import java.util.Scanner;

public class Bacteria {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double time = 0;        //elapsed time in tenths of seconds
        int currentSize = 0; //current size of the population
        int finalSize;          //final size of the population

        //  1. Get desired final size
        System.out.println("Enter the final size:");
        finalSize = input.nextInt();

        //  2. If the desired final size is invalid display an error message
        if (finalSize <= 1) { //population must start at 1 so final can't be 1?
            do {
                System.out.println("Invalid size");
                System.out.println("Enter the final size:");
                finalSize = input.nextInt();
            } while (finalSize <= 1);
        }

        //  3. Otherwise, determine the time required to achieve the final size
        else {
            //  3.1 Continue to calculate while the current size is less than the final size
            while (currentSize < finalSize) {
                //  3.1.1 Increase the time by a tenth of a second
                time += 0.1;

                //  3.1.2 Calculate the 'new' current size
                currentSize = (int) Math.pow(2, time / 3.2);
            }

            //4. Display the results
            System.out.printf("The final size will be reached in %.1f seconds", time);

        }

    } //end of main method

} //end of class
