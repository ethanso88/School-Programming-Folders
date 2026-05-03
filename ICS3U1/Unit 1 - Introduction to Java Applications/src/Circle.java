import java.util.Scanner;

//Name: Ethan So
//Date: Feb 13th 2024
//Course: ICS3U1-06 - Mr. Fernandes
//Description: A program to calculate the diameter, circumference and area from the radius inputted by the user
//Major Skills: variables, taking input, processing, printing output

public class Circle {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //used to read input
		
		//variables
		int radius, diameter; 
		double circumference, area; //area and circumference will involve decimals because of Pi
		
		//input
		System.out.print("Enter the radius here: ");
		radius = input.nextInt();
		input.close();
		
		//Processing - calculating results 
		diameter = 2 * radius;
		circumference = Math.PI * diameter;
		area = Math.PI * Math.pow(radius, 2);
		
		//Output - print the results
		System.out.printf("The diameter is %d\n", diameter);
		System.out.printf("The circumference is %.2f\n", circumference);
		System.out.printf("The area is %.2f\n", area);
		
	}

}
