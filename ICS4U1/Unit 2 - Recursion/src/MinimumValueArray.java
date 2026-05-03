import java.util.Arrays;

public class MinimumValueArray {

    public static void main(String[] args) {

        int[] numArray = new int[] {33, 2, 72, 24, 16, 65};

        int minimum = recursiveMinimum(numArray);

        System.out.printf("%d", minimum);

    }

    private static int recursiveMinimum(int[] num) {

        System.out.println(Arrays.toString(num));

        //base case, return when the array is 1 element
        if (num.length == 1)
            return num[0];

        //shrink the array
        //with each recursive call the ARRAY starts from index 1 (the second index)
        //each recursive call repeats until it reaches the base case
        int min = recursiveMinimum(Arrays.copyOfRange(num, 1, num.length));

        System.out.println("Current Minimum: " + min);
        System.out.println(Arrays.toString(num));

        //go up the array through recursion
        //after the base case has been met it will compare the number each time with an increased list by 1
        //it does this by returning back through the recursive calls
        if (num[0] > min)
            return min;
        else
            return num[0];

    }

//    private static int minValueArray(int[] intArray, int current, int smallest) {
//
//        //this method determines the smallest element in an array of integers
//        //the method should return when it receives an array of one element
//
//        //compare every value in the array
//        if (current < intArray.length) {
//
//            if (intArray[current] < intArray[smallest]) {
//                smallest = current;
//                return minValueArray(intArray, ++current, smallest);
//            } else
//                return minValueArray(intArray, ++current, smallest);
//        }
//
//        //base case
//        else
//            return intArray[smallest];
//
//    }

}
