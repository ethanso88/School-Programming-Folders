import java.util.Scanner; //import from a java utility package since it is not a part of the regular java language

//Name: Ethan So
//Date: Feb 6th 2024
//Course: ICS3U1-06 - Mr. Fernandes
//Description: A program to calculate the area of a circle
//Major Skills:
	//putting semicolon at the end of every line
	//declaring double variables
	//make an input with Scanner (and importing scanner)
	//take input as radius variable
	//calculating area with math functions

//*Note: .in is input and .out is output
//*Note: capital letters usually represent programs like AreaCircle and String

public class AreaCircle {
	
	public static void main(String[] args) {
		
		//Variables
		double radius; //input of the radius from the user
		double area; //output of the area from the program
		//double allows you to declare DECIMAL NUMBER variables in Java
		
//		**important line of code to remember**
		Scanner input = new Scanner(System.in); //NEW allows you to create an object
		//declare a scanner variable
		//input is a variable; System.in allows you to read (take input) from the keyboard
		
		//Input
		System.out.println("Enter the radius of the circle:");
		radius = input.nextDouble(); //nextDouble scans the next token of the input as a Double (variable)
		input.close(); //close the scanner but is not necessary when you're the only one using this file
		
		//Processing or calculations
		area = Math.PI * Math.pow(radius, 2); //pi times radius squared; pow for power function
		
		//Output
		System.out.printf("The area of a circle with radius %.2f is units %.2f squared.", radius, area);
		//'%' being the placeholder, '.2' being 2 decimal places, and 'f' being the variable (a FLOAT being a decimal variable)
	
	}

}
