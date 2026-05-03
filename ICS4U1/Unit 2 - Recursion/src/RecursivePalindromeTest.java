import java.util.Scanner;

public class RecursivePalindromeTest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //prompt user for a string
        System.out.println("Enter a string to test if its a palindrome:");
        String originalWord = input.next();

        //remove the punctuation
        String newWord = removePunctuation(originalWord);

        //test it
        boolean palindromeTest = isPalindrome(newWord, 0, newWord.length() - 1);

        //return the output
        if (palindromeTest)
            System.out.printf("The string %s IS a palindrome", newWord);
        else
            System.out.printf("The string %s is NOT a palindrome", newWord);

    }

    private static String removePunctuation(String originalWord) {

        //use a method from the Character wrapper class to determine if a letter is a space or not
        //taken from: https://stackoverflow.com/questions/21946042/remove-all-spaces-and-punctuation-anything-not-a-letter-from-a-string
        return originalWord.replaceAll("[^A-Za-z]+", "").toUpperCase();

    }

    //the recursive method isPalindrome returns a boolean value:
    // true, if the string stored in the array is a palindrome and false, otherwise
    public static boolean isPalindrome(String newWord, int left, int right) {
        //remember this method returns a boolean

        //test print lines
        System.out.printf("%d %d\n", left, right);
        System.out.printf("%s %s\n", newWord.charAt(left), newWord.charAt(right));

        //check if we are still approaching the midpoint
        if (left < right)

            //check if the first and last characters are identical
            if (newWord.charAt(left) != newWord.charAt(right))
                return false;
            else
                return isPalindrome(newWord, ++left, --right);  //recursive call
                // check the value of the shorter string and return the value to the original call



        //if there are no detected mismatched letters then it must be a palindrome
        //this must also be the midpoint
        return true;

    }

}
