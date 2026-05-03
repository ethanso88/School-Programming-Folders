import java.util.ArrayList;

public class SortMethods {

    //***the point of this method is to swap num1 and num2 elements
    private static void swap(int[] data, int num1, int num2) {

        //imagine a swap of data in a triangle
        //data[num1] goes to temp
        //temp goes to data[num2]
        //data[num2] goes to temp
        //them repeat and then data[num1] goes to temp
        int temp = data[num1];
        data[num1] = data[num2];
        data[num2] = temp;

        //note that temp is discarded
        //***the point of this method is to swap num1 and num2 elements

    }

    //***the point of this method is to swap num1 and num2 elements
    private static void fasterSwap(int[] data, int num1, int num2) {

        data[num1] = data[num1]^data[num2];
        data[num2] = data[num1]^data[num2];
        data[num1] = data[num1]^data[num2];

        //example for visualization
        //num1 = 1100
        //num2 = 1010
        //num1 = num1 ^ num2 = 1100 ^ 1010 = 0110
        //num2 = num1 ^ num2 = 0110 ^ 1010 = 0110
        //num1 = num1 ^ num2 = 0110 ^ 1100 = 0110
        //num2 = 1010
        //num1 = 1100

    }

    public static void bubbleSort(int[] data) {

        //starting at the largest index until the second last index
        //  ensures loops = all indexes - 1, don't need to swap 1 element
        for (int x = data.length -1; x > 0; x--) {

            boolean swapped = false;

            //swap the data according to the number of indexes left to swap/sort
            //don't need to swap an already sorted index
            for (int y = 0; y < x; y++)

                //if previous data is bigger than the next data then swap
                if (data[y] > data[y + 1]) {
                    swap(data, y, y + 1);
                    swapped = true;
                }

            //end when no swaps (sorted)
            if (!swapped)
                break;

        }

    }

    public static void selectionSort(int[] data){

        //for all indices in the array
        for (int x = 0; x < data.length - 1; x++) {

            // Assume the current position holds
            // the minimum element
            int smallest = x;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int y = x + 1; y < data.length; y++) {
                if (data[y] < data[smallest]) {

                    //we keep marking until a new smallest value is found
                    //update smallest if a smaller element is found
                    //we mark the smallest until the end of the loop
                    smallest = y;
                }
            }

            // Move minimum element to its
            // correct position
            //What swap does:
//            int temp = data[x];
//            data[x] = data[smallest];
//            data[smallest] = temp;
            swap(data, x, smallest);
        }
    }

    public static void insertionSort(int[] data) {

        // --x is a PRE-decrement, decreases by 1 BEFORE it sends the data
        // x-- is a POST-decrement, decreases by 1 AFTER it sends the data

        //iterate through all indices in the array except for the first (since its already "sorted")
        for (int x = 1; x < data.length; x++)

            //iterate from the current element back to the beginning of the array
            //swap the available data
            //element y (the previous element) is compared to element x (the highest in the available data)
            //everytime x increases in the main loop it is INSERTED into the NEW available data
            for (int y = x - 1; y >= 0; y--) {

                //if the inserted element is less than y then swap it
                if (data[x] < data[y])

                    //swap elements and move the current element one position to the left
                    //then the loop repeats to see if x is less than the position before it again
                    swap(data, x--, y);

                else

                    //if the current element is greater or equal to the element at index y, break the loop
                    break;

            }


    }

    //method for counting sort
    public static void countingSort(int[] data, int range) {
        //limitation is the amount of wasted data from a large array

        int[] count = new int[range];

        //This for loop does the tallying
        //for example if you see one 3 and two 7's then
        //the count for 3's goes up by one and the count for 7's goes up by two
        for (int x = 0; x < data.length; x++)
            count[data[x]]++;


        //use index so that no element in the list is replaced
        int index = 0;

        //put the data back in from the "counted buckets" ex: # of 3's
        //repeat by the number of counted digits
        for (int x = 0; x < count.length; x++) {

            //if there is a count of that number
            if (count[x] > 0)

                //put that number in the original list for how many times it was counted
                for (int y = 0; y < count[x]; y++) {

                    data[index] = x;
                    index++; //move to next element in original list

                }




        }


    }

    //method for bucket sort
    public static void bucketSort(int[] data, int range) {
        //magic buckets that can grow as needed
        //what if the numbers are between 1-100 but most of the data is in the lower digits b/w 1-10?
        //it would be a waste of time to sort the large data since it is just the same
        //*THUS this is NOT a good algorithm if the range isn't EVENLY SPREAD

        //generally the best way to divide the data
        int numBuckets = (int) Math.sqrt(range) + 1;

        //bucket array, ArrayList Array
        ArrayList<Integer>[] bucket = new ArrayList[numBuckets];

        //initialize
        for (int x = 0; x < numBuckets; x++)
            bucket[x] = new ArrayList<Integer>();

        //what bucket should the data go into
        for (int x = 0; x < data.length; x++)
            //ex add 10 to the 2nd bucket if there are 4 buckets
            // in that case sorting the data into quartiles
            bucket[data[x] / numBuckets].add(data[x]);


        //use index so that no element in the list is replaced
        int index = 0;

        //repeat by the number of buckets (for each bucket)
        for (int x = 0; x < numBuckets; x++) {

            //if theres something in the bucket sort it
            if (bucket[x].size() > 0) {

                //convert the ArrayList<> back into an Array so we can use it in one of the prior sorts
                int[] tempBucket = new int[bucket[x].size()];

                //bucket is a list so just retrieve every element in the list
                for (int y = 0; y < tempBucket.length; y++)
                    tempBucket[y] = bucket[x].get(y);

                //usually use insertion sort in bucket sort since the buckets usually don't vary too much in data and size
                insertionSort(tempBucket);

                //put the data back in
                for (int y = 0; y < tempBucket.length; y++)
                    data[index++] = tempBucket[y];

            }
        }
    }

    //method for radix sort
    public static void radixSort(int[] data, int range) {

        //find the most significant digit to know the number of digits
        //*how many digits long is the number (# of loops)
        int msd = (int) (Math.log10(range) + 1);
        //log10 gives us the value of the exponent 10^x where x is the number of digits

        //create an ArrayList Array for the digit places
        //*10 represents each digit place. 10 total digits: 0,1,2,3,...,9
        ArrayList<Integer>[] digit = new ArrayList[10];

        //initialize each index in the Array with an ArrayList
        for (int x = 0; x < 10; x++)
            digit[x] = new ArrayList<Integer>();


        //*repeat by each digit place (place value)
        for (int x = 0; x < msd; x++) {

            //*distribute elements into buckets based on the current digit
            for (int y = 0; y < data.length; y++)
                //digit index = data[y] / 10^x = correct place value number
                // then % 10 which gives the actual place value digit
                //.add(data[y]) then adds the number to its appropriate digit place
                //this process naturally sorts the numbers based on place value
                digit[(int) (data[y] / Math.pow(10, x) % 10)].add(data[y]);

            //*collect the elements from the buckets and update the original array
            int index = 0; //use index so that no element in the list is replaced
            //for each digit (10)
            for (int y = 0; y < 10; y++)
                //while there IS something in the array
                while (!digit[y].isEmpty()) {
                    //add it to the original array and then wipe the memory
                    //  of the digit array for the next place value
                    data[index++] = digit[y].removeFirst();
                }

        }

    }

    public static void shellSort(int[] data) {

        //if you performed a swap make sure it didn't put another number out of order before reducing the gap
        //if we perform a swap the while loop will come true
        //this then makes sure all swaps are done before reducing the gap to ensure it's in order


    }

    public static void quickSort(int[] data, int start, int end) {


        int left = start; //index
        int right = end; //index
        //first choose a pivot
        int pivot = data[(start + end) / 2];
        //pivot point, or seesaw point can be anywhere
        //however the middle is efficient since we sort the data on both sides

        //PARTITION
        //next separate the array
        //we need to be able to sort the array to left and right of the pivot (less than and greater than)
        //*the left and right pointers are used to traverse the array from both ends to find elements that need to be swapped.
        while (left <= right) {

            //if this condition is true then it is already less than the pivot
            //thus we increase the count and mark it as "covered" already
            while (data[left] < pivot)
                left++;

            //same concept above, marking the data
            while (data[right] > pivot)
                right--;

            //if left <= right means if the left indexes are left of the pivot still
            if (left <= right) {

                //then swap the data (elements in the array)
                swap(data, left, right);

                //we have now "covered" or sorted a left and right element
                left++;
                right--;

            }

        }

        //RECURSION
        //“Repeat” the previous steps sort of by recursively calling and applying the same steps to the left and right arrays.
        //The recursion continues until there is only 1 element left in the sub array (by then it will be sorted, nothing to compare)
        //  Basically when all the pivots only sort 1 element,
        //      remember that there are the bottom two statements in each recursion method, so it will divide each side into more sides again until it reaches 1 element in a side
        //  => the base case (like sentinel value) for the recursion is when the subarray has only one element or is empty

        //continue to sort the data b/w start and right which would be left of the pivot
        //when start = right it would be 1 element left or otherwise sorted, so it would not continue
        if (start < right)
            quickSort(data, start, right);

        //continue to sort the data b/w left and end which would be right of the pivot
        if (left < end)
            quickSort(data, left, end);
    }

    //the driver method (how do we start the process)
    public static void mergeSort(int[] data, int start, int end) {




    }

    private static void merge(int[] data, int start, int end) {

        //take data from each side and add it accordingly (sorted)
        //{3, 7} and {5,10}
        //=> {3,5,7,10}

        //we are pulling from both sides
        //what if one side is in order thought

        //if there is nothing left in the left array just put the data from the right array

        //if there is nothing left in the right array just put the data from the left array

    }

    public static void cocktailSort(int[] data) {

        //traverse the list until the midpoint
        for (int x = 0; x <= data.length/2 +1; x++) {

            //set swapped checker to false
            boolean swapped = false;

            //traverse from L to R to see if theres a swap
            for (int y = x; y < data.length - (x+1); y++)

                //compare the current number with the next number
                if (data[y] > data[y+1]) {
                    //if current is greater than next then swap them
                    swap (data, y, y+1);

                    //set swapped checker to true
                    swapped = true;
                }

            //check if swapped checker is false
            //if it is false there would be no swaps, thus it would be sorted
            if (!swapped)
                break;

            //traverse from R to L to see if theres a swap
            //traverse from the length of the list minus the already sorted number from above
            for (int y = data.length - (x+1); y > x; y--)

                //compare the current number with the previous number
                if (data[y] < data[y-1]) {
                    //if current is less than previous then swap
                    swap(data, y, y-1);

                    //set swapped checker to true
                    swapped = true;
                }

            //check if swapped checker is false
            //if it is false there would be no swaps, thus it would be sorted
            if (!swapped)
                break;

        }


    }


    //different method of radix sort
    /*
    //method to get maximum value in data[]
    static int getMax(int[] data) {
        //assume first num is max
        int maxNum = data[0];

        //iterate through the rest of the array and update the number
        //everytime a bigger number is found
        for (int x = 1; x < data.length; x++)
            if (data[x] > maxNum)
                maxNum = data[x];

        return maxNum;
    }
    //Radix Sort method that sorts data[] with size 'range' using Radix Sort (LSD)
    //start from least significant digit
    public static void radixSort(int[] data, int range) {

        //find the maximum number to know number of digits (# of loops)
        //how many digits long is the number
        int maxNum = getMax(data);

        //use counting sort for each digit
        //each iteration is a cycle of the exponent 10^x (digit place)
        //where x is current digit number
        for (int exp = 1; maxNum / exp > 0; exp *= 10)
            countingSort(data, exp);
        //ends once the exponent exceeds the numbers of digits as ex: 123/1000 will always be a fraction
    }
     */

    //different methods for quick sort
    /*
    //separation function at a pivot
    public static int partition(int[] arr, int low, int high) {

        // Choose the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // The QuickSort function implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
     */

}
