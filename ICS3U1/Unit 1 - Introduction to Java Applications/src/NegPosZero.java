import java.util.Scanner;

//Name: Ethan So
//Date: Feb 15th 2024
//Course: ICS3U1-06 - Mr. Fernandes
//Description: Displays the number of negative, positive and zero numbers from the 5 numbers inputed
//Major Skills: Create variables to set to 0 and hold count

public class NegPosZero {

	public static void main(String[] args) {
		
		//Variables
		Scanner input = new Scanner(System.in);
		int countNegative = 0; 
		int countPositive = 0; 
		int countZero = 0; 
		int num1, num2, num3, num4, num5;
		
		//I - input the 5 numbers 
		System.out.print("Enter 5 numbers: ");
		num1 = input.nextInt();
		num2 = input.nextInt();
		num3 = input.nextInt();
		num4 = input.nextInt();
		num5 = input.nextInt();
		input.close();
		
		//P - determine if each number is either negative, positive or zero 
		if (num1 < 0) //if num1 is less than 0 it is negative 
			countNegative++; //increment count of negatives 
		else if (num1 > 0)
			countPositive++; //increment
		else
			countZero++; //increment
		
		if (num2 < 0) 
			countNegative++; 
		else if (num2 > 0)
			countPositive++; 
		else
			countZero++;
		
		if (num3 < 0) 
			countNegative++; 
		else if (num3 > 0)
			countPositive++; 
		else
			countZero++;
		
		if (num4 < 0) 
			countNegative++; 
		else if (num4 > 0)
			countPositive++; 
		else
			countZero++;
		
		if (num5 < 0) 
			countNegative++; 
		else if (num5 > 0)
			countPositive++; 
		else
			countZero++;
		
		//O - display results 
		System.out.println("There are:");
		System.out.printf("%d negative number(s)\n%d positive number(s)\n%d zero number(s)"
				, countNegative, countPositive, countZero);
			
	}

}
