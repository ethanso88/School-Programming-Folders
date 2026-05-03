import java.util.Scanner;

/*
*Name: Ethan So
*Date: Feb 15th 2024
*Course: ICS3U1-06 - Mr. Fernandes
*Description: Calculates the volume of a sphere
*Major Skills: 
*/

public class SphereVolume {
	
	public static void main(String[] args) {
		
		//variables
		Scanner input = new Scanner(System.in);
		double radius;
		double volume; 
		
		//I - get radius 
		System.out.print("Enter the radius: ");
		radius = input.nextDouble(); 
		
		//P - calculate volume 
		volume = (double) 4/3 * Math.PI * Math.pow(radius, 3); 
		
		//O - Display volume 
		System.out.printf("The volume of the sphere with radius %.2f is %.2f units cubed", radius, volume);
		//remember to put units cubed or else marks lost
		
	}

}
