import java.util.Scanner;

//Name: Ethan So
//Date: Feb 13th 2024
//Course: ICS3U1-06 - Mr. Fernandes
//Description: A program to calculate the product of 3 integers from the user
//Major Skills: make input with Scanner, declare variables, calculate product, print output

public class Product {
    
    public static void main(String[] args) {
        //make input variable with Scanner
        Scanner input = new Scanner(System.in);
        
        //declare integer variables
        int num1;
        int num2;
        int num3;
        int product;
        
        //Input - take input from the user
        System.out.println("Enter 3 integers: ");
        num1 = input.nextInt();
        num2 = input.nextInt();
        num3 = input.nextInt();
        input.close();
        
        //Process - calculate product
        product = num1 * num2 * num3;
        
        //Output
        System.out.printf("The product of %d, %d, and %d is %d", num1, num2, num3, product);
        
    }

}