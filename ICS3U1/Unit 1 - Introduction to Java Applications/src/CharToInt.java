import java.util.Scanner;

//Name: Ethan So
//Date: Feb 15th 2024
//Course: ICS3U1-06 - Mr. Fernandes
//Description: Displays integer related to a character based on ASCII code
//Major Skills: taking input of one character
public class CharToInt {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		
		//variables
		char letter;
		
		//Input - taking input 
		System.out.print("Enter a character to be displayed as an integer: ");
		letter = input.next().charAt(0);
		//next being the next String and 0 being the 1st character
		input.close();
		
		//Output
		System.out.println("The character " + letter + " is the number " + (int) letter);
		//remember to convert the letter to an integer to get the ASCII code number
		
	}

}
