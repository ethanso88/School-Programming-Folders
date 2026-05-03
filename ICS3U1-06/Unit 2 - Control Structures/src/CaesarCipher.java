import java.util.*;

/*links used
https://www.edureka.co/community/162130/does-java-have-a-in-operator-or-function-like-sql-duplicate#:~:text=There%20is%20no%20such%20operator,written%20to%20facilitate%20such%20queries.
https://stackoverflow.com/questions/57032361/how-to-turn-a-string-into-an-array-of-strings
https://stackoverflow.com/questions/8238456/how-to-get-value-at-a-specific-index-of-array-in-javascript
https://stackoverflow.com/questions/23160832/how-to-find-index-of-string-array-in-java-from-a-given-value
https://stackoverflow.com/questions/7693994/how-to-convert-ascii-code-0-255-to-its-corresponding-character
 */


public class CaesarCipher {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        String message;
        String[] alphabet = { "a","b","c","d","e","f","g","h","i","j","k",
                "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z" };
        int letters;
        String letter;
        String index;
        int ascii;
        int shift;
        String[] result;

        //Prompt the user for the message they want to encrypt
        System.out.println("Enter a message to encrypt:");
        message = input.next();
        message = message.toLowerCase(); //set to lowercase

        //Prompt the user for the shift required
        System.out.println("Enter the amount of shift:");
        shift = input.nextInt();

        //Find number of letters in the message
        letters = message.length();

        //turn message into an array to get individual letters from
        String[] messageList = message.split(",");

        //For each letter in the message
        for (int x = 0; x < letters; x++) {
            letter = messageList[x];

            //If the letter is a letter in the alphabet
            if (Arrays.asList(alphabet).contains(letter)) {
                //Find the letter in your created alphabet
                ascii = Arrays.asList(alphabet).indexOf(letter);
                //using ASCII code

                //add shift to letter
                index = Character.toString(ascii + 97 + shift);

                //Add letter to the result
                result.append(index);

            }
            //Else
            else {
                //Add the actual thing if it"s not a letter to result (ex: punctuation)
            }

        }

        //Display the encrypted message or print result


    }

}
