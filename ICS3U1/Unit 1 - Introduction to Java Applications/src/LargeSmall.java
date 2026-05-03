import java.util.Scanner;

//Name: Ethan So
//Date: Feb 13th 2024
//Course: ICS3U1-06 - Mr. Fernandes
//Description: Displays the largest and smallest of 5 integers
//Major Skills: Decision structure to decide and replace smallest/largest 
public class LargeSmall {
	
	public static void main(String[] args) {
		
		//input variable
		Scanner input = new Scanner(System.in);
		
		//variables
		int num1, num2, num3, num4, num5;
		int smallest, largest;
		
		//Input - get input for the 5 integers
		System.out.println("Enter 5 integers: ");
		num1 = input.nextInt();
		num2 = input.nextInt();
		num3 = input.nextInt();
		num4 = input.nextInt();
		num5 = input.nextInt();
		input.close();
		
		//Processing:
		
		//set smallest and largest as num1 first 
		smallest = num1;
		largest = num1;
		
		//compare the other numbers to the current smallest or largest 
		//this is to check if they should be reassigned to a different number
		if (num2 < smallest) //check num2 first and so on
			smallest = num2;
		else if (num2 > largest)
			largest = num2; 
		
		if (num3 < smallest) 
			smallest = num3;
		else if (num3 > largest)
			largest = num3; 
		
		if (num4 < smallest) 
			smallest = num4;
		else if (num4 > largest)
			largest = num4; 
		
		if (num5 < smallest) 
			smallest = num5;
		else if (num5 > largest)
			largest = num5; 
		
		//Output
		System.out.printf("The smallest number is %d\n", smallest);
		System.out.printf("The largest number is %d\n", largest);
		
	}

}
