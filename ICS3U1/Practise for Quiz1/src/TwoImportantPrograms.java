import java.util.Scanner; //import java utility package for scanner

//Note that while this program does have the 2 important lines of code 
//Its PURPOSE is to take an input and output it
public class TwoImportantPrograms {
	
	//**Important Program (or line of code) #1
	//PSV MSA 
	public static void main(String[] args) {
		
		double output;
		
		//**Important Program #2
		Scanner input = new Scanner(System.in);
		//Understanding: input = function Scanner(keyboard input)
		//NOTE: scanner can only take NUMBERS as input
		
		System.out.print("Enter your input: \n");
		output = input.nextDouble(); //nextDouble scans the next token of input
		input.close();
		
		//output 
		System.out.println(output);
		
	}
}
