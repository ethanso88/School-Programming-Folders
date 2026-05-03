import java.util.Scanner;

/*
Name: Ethan So
Date: 2/20/2024
Course: ICS3U1-06 Mr. Fernandes
Description: A program that gives the surface area and volume of a cylinder
Major Skills:
 */

public class Cylinder {

    public static void main(String[] args) {

        //Variables
        Scanner input = new Scanner(System.in);
        double radius, height; //Input variables
        double surfaceArea, volume; //Output variables

        //I - Input radius and height
        System.out.println("Enter the radius of the cylinder:");
        radius = input.nextDouble();
        System.out.println("Enter the height of the cylinder:");
        height = input.nextDouble();

        //P - Calculate Surface area and Volume
        surfaceArea = (2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius, 2)); //2πrh + 2πr²
        volume = Math.PI * Math.pow(radius, 2) * height; //πr²h

        //O - Display Surface area and Volume
        System.out.printf("The surface area of the cylinder is %.2f units squared", surfaceArea);
        System.out.printf("The volume of the cylinder is %.2f units cubed", volume);

    }

}
