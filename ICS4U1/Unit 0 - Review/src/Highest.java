
import java.util.Arrays;
import java.util.Scanner;

public class Highest {

    //main method
    public static void main(String[] args) {

        //create scanner to take variables
        Scanner ScannerInput = new Scanner(System.in);

        //integer array
        System.out.println("Enter the first number");
        int highest = ScannerInput.nextInt();
        int num;

        //sentinel
        int count = 0;

        //This keeps on repeating till it hits the count or the condition in the while loop
        while (count < 9) {

            //
            System.out.println("Enter the next number");
            num = ScannerInput.nextInt();


            if (num > highest) {
                highest = num;
            }

            count++;

            System.out.printf("position number %d \n", count + 1);

        }

        System.out.printf("The highest number is %d", highest);

    }

}
