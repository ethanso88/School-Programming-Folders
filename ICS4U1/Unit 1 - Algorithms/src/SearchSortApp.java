import java.util.Arrays;
import java.util.Scanner;

public class SearchSortApp {

    public static void main(String[] args) {

        // Scanner object used for input
        Scanner input = new Scanner(System.in);


        // Prompt user for the size of the data sets
        System.out.println("Enter the size of the array:");
        int size = input.nextInt();

        // CREATING DATA SETS //

        // create a 2d array that holds 4 different types of data sets
        int[][] data = new int[4][size];

        // Random data
        for (int x = 0; x < size; x ++) {
            data[0][x] = (int) (Math.random() * size) + 1;
        }

        // Ordered
        for (int x = 0; x < size; x++) {
            data[1][x] = x + 1;
        }

        //90% ordered - First creates an ordered list and then randomizes 10% of items
        for (int x = 0; x < size; x++) {
            data[2][x] = x + 1;
        }

        for (int x = 0; x < size; x++) {
            data[2][(int) (Math.random() * size)] = (int) (Math.random() * size) + 1;
        }

        // Reverse
        for (int x = 0; x < size; x++) {
            data[3][x] = size - x;
        }

        // Display the data sets prior to running algorithms
        for (int[] list : data) {

            // Limit console output to only smaller data sets
            if (size <= 100) {
                System.out.println(Arrays.toString(list));
            }
            else {
                System.out.println("Array Created");
            }
        }


        //Prompt for the type of algorithm
        System.out.println("Select 1) Search or 2) Sort:");
        int type = input.nextInt();

        //Searching algorithms
        if (type == 1) {

            //Prompt for the specific searching algorithm
            System.out.println("Enter the type of search algorithm:" +
                    "\n1) Linear Search\n2) Binary Search\n3) Exponential Search");
            int algorithm = input.nextInt();

            //Stores the index of the item to be found (-1 meants the item is not in the list)
            int index = 0;

            //Prompt user for the item to be found
            System.out.println("Enter the item to be found:");
            int item = input.nextInt();

            //Being a timer for analysis
            long start = System.nanoTime();

            //Run the selected algorithm; note that some algorithms require the list to be sorted first
            //therefore you could either use the ordered dataset - data[1]
            //or else sort the random data set first - data[0]
            if (algorithm == 1)
                index = SearchMethods.linearSearch(data[2], item);
            else {

                //Arrays.sort(data[0]);     //not needed if using the ordered data set - data[1]

                if (algorithm == 2)
                    index = SearchMethods.binarySearch(data[1], item);
                else if (algorithm == 3)
                    index = SearchMethods.exponentialSearch(data[1], item);
            }

            //Displays the elapsed time and the result of the search
            System.out.printf("Elapsed time: %d nanoseconds\n", System.nanoTime() - start);

            if (index == -1)
                System.out.println("Item not found");
            else
                System.out.println("Item found in index " + index);

        }


        //Sorting Algorithm
        else {

            //Prompt for the specific searching algorithm
            System.out.println("Enter the type of sort algorithm:\n"
                    + "1) Bubble Sort\n2) Selection Sort\n3) Insertion Sort\n" +
                    "4) Counting Sort\n5) Bucket Sort\n6) Radix Sort\n" +
                    "7) Shell Sort\n8) Quick Sort\n9) Merge Sort\n" +
                    "10) Cocktail Sort\n");

            int algorithm = input.nextInt();

            //Run the specific algorithm on each of the different data sets
            for (int[] list : data) {

                //Begin a timer for analysis
                long start = System.nanoTime();

                //Run the selected algorithm; note that some algorithms may require additional arguments
                if (algorithm == 1)
                    SortMethods.bubbleSort(list);
                else if (algorithm == 2)
                    SortMethods.selectionSort(list);
                else if (algorithm == 3)
                    SortMethods.insertionSort(list);
                else if (algorithm == 4)
                    SortMethods.countingSort(list, size);
                else if (algorithm == 5)
                    SortMethods.bucketSort(list, size);
                else if (algorithm == 6)
                    SortMethods.radixSort(list, size);
                else if (algorithm == 7)
                    SortMethods.shellSort(list);
                else if (algorithm == 8)
                    SortMethods.quickSort(list,0,size - 1);
                else if (algorithm == 9)
                    SortMethods.mergeSort(list, 0,size - 1);
                else if (algorithm == 10)
                    SortMethods.cocktailSort(list);

                //Displays the elapsed time and results of the sort
                System.out.printf("Elapsed time: %d nanseconds\n", System.nanoTime() - start);

                //Limit console output to only smaller data sets
                if (size <= 100)
                    System.out.println(Arrays.toString(list));
                else
                    System.out.println("Array Sorted");

            }
        }

    }

}
