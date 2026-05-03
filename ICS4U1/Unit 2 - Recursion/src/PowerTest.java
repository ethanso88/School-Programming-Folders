import java.util.Scanner;

public class PowerTest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //get user input
        System.out.println("Enter the base and exponent for the power b^n in that order:");
        int base = input.nextInt();
        int exponent = input.nextInt();

        //call the method to receive recursive value
        int power = power(base, exponent);

        //output
        System.out.printf("The value of the power %d^%d is %d", base, exponent, power);


    }

    public static int power(int base, int exponent) {

        //base case
        //if power = b^1, power = b
        if (exponent == 1)
            return base;
        //recursive call
        //power b^n = b * b^(n-1)
        else
            return base * power(base, exponent - 1);
        
    }

}
