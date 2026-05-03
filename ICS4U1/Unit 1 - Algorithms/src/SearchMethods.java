import java.util.Arrays;

public class SearchMethods {

    //method that performs linear search when called
    public static int linearSearch(int[] data, int item) {
        //two variables from the app
        //data array that holds the list of data
        //item that holds the desired "target" element

        //iterate throughout the entire array (list of data)
        for (int x = 0; x < data.length; x++)
            //start checking from the first index

            //check if the searched element matches with the target element
            if (data[x] == item)
                return x; //if yes then return the index of the element found

        //If the end of the array is reached without a match terminate the program and return “-1”
        return -1; //element not found

    }

    //method that performs binary search when called
    //assumes data is in sorted order
    public static int binarySearch(int[] data, int item) {

        //set high and low
        int low = 0, high = data.length - 1;

        while (low <= high) {
            //split data into half
            int mid = (low + high) >> 1;  // >> 1 is faster than / 2

            if (data[mid] == item) {
                return mid;  // Item found
            } else if (data[mid] < item) {
                low = mid + 1;  // Search left half
            } else {
                high = mid - 1;  // Search right half
            }
        }

        return -1;  // Item not found

    }

    //assumes data is in sorted order
    public static int exponentialSearch(int[] data, int item) {

        // Check if first element of array is the value and return if so
        if (data[0] == item)
            return 0;

        // Start at index 1
        int i = 1;
        // While index is within array size
        // and element of array at index is less than search value
        while (i < data.length && data[i] < item)
            // Double i, increasing range checked each time
            i *= 2;

        // Create array with the range where value is
        data = Arrays.copyOfRange(data, i / 2, Math.min(i, data.length));

        // Binary search the new array and add index/2 to make up for
        // what was lost when array was copied with new size
        return binarySearch(data, item + (i / 2));

    }

    //failed linearSearch code attempt
//    public void linearSearch() {
//
//        ArrayList<Integer> linearArray = new ArrayList<>();
//
//        int target = 0;
//        int searched;
//        boolean matched = false;
//
//        //Put the desired searched “target” element in the first index of the array
//        linearArray.addFirst(target);
//
//        //Next compare the target element with the next element in the array
//
//
//        for (int count = 0; count < linearArray.size(); count++) {
//
//            searched = linearArray.get(count);
//            //If the target element and the search element are the same it is a “match” and terminate the program
//            if (linearArray.contains(target) == linearArray.contains(searched)) {
//                System.out.println("Found at index " + target);
//                matched = true;
//            }
//            //If not then compare the target element with the next element in the array
//
//        } //Continue steps 3 and 4 until you find a matching element
//
//        //If the end of the array is reached without a match terminate the the program and return “Element not found”
//        if (!matched)
//            System.out.println("No match found");
//
//    }

}
