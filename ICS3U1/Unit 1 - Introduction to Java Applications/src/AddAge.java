import java.util.Scanner;

//Name: Ethan So
//Date: Feb 15th 2024
//Course: ICS3U1-06 - Mr. Fernandes
//Description: Displays and output with the age of the person next year
//Major Skills: increment (age++)

public class AddAge {
	
	public static void main(String[] args) {
		
		//Variables
		Scanner input = new Scanner(System.in); //input with Scanner 
		String firstName, lastName; 
		int age;
		
		//I - input first and last name, and age 
		System.out.println("Enter your first name, last name and age: ");
		firstName = input.next();
		lastName = input.next();
		age = input.nextInt();
		input.close();
		
		//P - add one year to the age 
		age++; //or age = age + 1; 'increment'
		
		//O - Display statement with 1 higher age 
		System.out.printf("%s %s next year you will be %d", firstName, lastName, age);
		
	}

}
