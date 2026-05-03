public class PrintArray {

    public static void main(String[] args) {

        int[] integerArray = new int[] {10,20,30,40,50};

        printArray(integerArray, 0);

    }

    private static void printArray(int[] intArray, int index) {

        //base case, reaches end of the list
        if (index == intArray.length - 1)
            System.out.print(intArray[intArray.length - 1]);

        //Display the current number and move the index up by 1 and call the method again
        else {
            System.out.print(intArray[index] + " ");
            printArray(intArray, ++index); //pre-increment
        }
    }

}
