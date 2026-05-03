import java.util.Scanner;

public class GCDTest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //prompt user for two numbers
        System.out.println("Enter two numbers to find the GCD:");
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        //find the gcd
        int gcd = gcd(num1, num2);

        //return the output
        System.out.printf("The gcd of %d and %d is %d", num1, num2, gcd);

    }

    public static int gcd(int x, int y) {

        //The gcd of x and y is defined recursively as follows:
        // If y is equal to 0, then gcd(x, y) is x
        if (y == 0)
            return x;
        // otherwise, gcd(x, y) is gcd(y, x % y), where % is the remainder operator
        else
            return gcd(y, x % y);

    }

}
