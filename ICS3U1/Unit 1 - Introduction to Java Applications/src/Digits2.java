import java.util.Scanner;

//Name: Ethan So
//Date: Feb 15th 2024
//Course: ICS3U1-06 - Mr. Fernandes
//Description: Displays a 5 digit integer with spaces in between (STRING METHOD)
//Major Skills: Converting an integer to a string, printing each character at each position

public class Digits2 {
	
	public static void main(String[] args) {
		
		//Variables
		Scanner input = new Scanner(System.in); //input with Scanner 
		int number; //5 digit number 
		String stringNum; //create String variable to hold the String version of the number
		
		//I - input 5 digit number
		System.out.print("Enter 5 digit number: ");
		number = input.nextInt();
		input.close();
		
		//P - Convert number into a string 
		stringNum = Integer.toString(number); //Integer is a 'Wrapper' class
		
		//O - output the String while separating the characters with a space
		System.out.printf("%s %s %s %s %s", stringNum.charAt(0), stringNum.charAt(1),
				stringNum.charAt(2), stringNum.charAt(3), stringNum.charAt(4));
		
	}

}
