import java.util.Scanner;

//Name: Ethan So
//Date: Feb 15th 2024
//Course: ICS3U1-06 - Mr. Fernandes
//Description: Displays a 5 digit integer with spaces in between (MATH METHOD)
//Major Skills: Dividing to extract each digit of the 5 digit integer

public class Digits {
	
	public static void main(String[] args) {
		
		//Variables
		Scanner input = new Scanner(System.in); //input with Scanner 
		int number; //5 digit number 
		int d1, d2, d3, d4, d5; //individual digits
		
		//Input - input 5 digit number
		System.out.print("Enter a 5 digit number: "); 
		number = input.nextInt();
		input.close();
		
		//P - isolate each digit 
		d5 = number % 10; //% means modulus which is basically remainder. 
		//would get the remainder if you divide by 10 which is the units digit 
		number = number / 10; //divide the number by 10 to "shift" the number right. 
		//since it is an integer the divided number will just shift and round (remainder just "disappears") 
		
		d4 = number % 10; //tens digit 
		number = number / 10; //'shift' the number right
		
		d3 = number % 10; //hundreds digit 
		number = number / 10; //'shift' the number right
		
		d2 = number % 10; //thousands digit 
		number = number / 10; //'shift' the number right
		
		d1 = number; //tens thousands digit  
		//don't need to use '%' since it will be the last number left
		
		//O - print the digits with the spaces
		System.out.printf("%d %d %d %d %d", d1, d2, d3, d4, d5);
		
	}

}
