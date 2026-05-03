public class PrintArrayBackwards {

    public static void main(String[] args) {

        String word = "Computers";

        char[] letterArray = word.toCharArray();

        //length is a METHOD for the STRING word
        //length is a VARIABLE (parameter) for an ARRAY
        printArrayBackwards(letterArray, word.length() - 1);

    }

    private static void printArrayBackwards(char[] letterArray, int index) {

        //base case, reaches beginning of the list
        if (index == 0)
            System.out.print(letterArray[index]);

        //Display the current number and move the index down by 1 and call the method again
        else {
            System.out.print(letterArray[index] + " ");
            printArrayBackwards(letterArray, --index); //pre-decrement
        }
    }

}
