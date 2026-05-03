public class SortAlgorithms {

    // ======================
    // QUICK SORT ALGORITHM
    // ======================
    public static void quickSort(int[] data, int start, int end) {
        int left = start;
        int right = end;

        // Choose the pivot as the middle element
        int pivot = data[(start + end) / 2];

        // Partition step
        while (left <= right) {

            // Move left index forward until an element >= pivot is found
            while (data[left] < pivot) {
                left++;
            }

            // Move right index backward until an element <= pivot is found
            while (data[right] > pivot) {
                right--;
            }

            // Swap elements if necessary
            if (left <= right) {
                swap(data, left, right);
                left++;
                right--;
            }
        }

        // Recursively sort the left and right partitions
        //make sure the right is greater than the start
        if (start < right) {
            quickSort(data, start, right);
        }

        //make sure the left is not at the end
        if (left < end) {
            quickSort(data, left, end);
        }
    }

    // Helper method to swap two elements in the array
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }




    // PUBLIC method to start merge sort on an array
    public static void mergeSort(int[] data, int start, int end) {
        // Base case: if there is 1 or fewer elements in this portion, it's already sorted
        if ((end - start) >= 1) {
            // Find the midpoint (integer division)
            int middle = (start + end) / 2;

            // Recursively sort the left half (start to middle)
            mergeSort(data, start, middle);

            // Recursively sort the right half (middle + 1 to end)
            mergeSort(data, middle + 1, end);

            // Merge the two sorted halves into one sorted portion
            merge(data, start, end);
        }
    }

    // PRIVATE helper method that merges two sorted halves
    private static void merge(int[] data, int start, int end) {
        int mergeIndex = 0;  // Position in the merged array

        int middle = (start + end) / 2;  // Midpoint of the current subarray
        int leftIndex = start;          // Start of the left sorted half
        int rightIndex = middle + 1;    // Start of the right sorted half

        // Temporary array to hold the merged result
        int[] mergedSubArray = new int[end - start + 1];

        // Merge elements from left and right halves in sorted order
        while (leftIndex <= middle && rightIndex <= end) {
            // If the current left element is smaller, it goes next in merged array
            if (data[leftIndex] < data[rightIndex]) {
                mergedSubArray[mergeIndex] = data[leftIndex];
                leftIndex++;  // Move left pointer forward
            } else {
                // Otherwise, take the right element
                mergedSubArray[mergeIndex] = data[rightIndex];
                rightIndex++;  // Move right pointer forward
            }
            mergeIndex++;  // Move merge pointer forward
        }

        // At this point, at least one half is fully copied.
        // Copy remaining elements from the right half (if any)
        while (rightIndex <= end) {
            mergedSubArray[mergeIndex] = data[rightIndex];
            rightIndex++;
            mergeIndex++;
        }

        // Or copy remaining elements from the left half (if any)
        while (leftIndex <= middle) {
            mergedSubArray[mergeIndex] = data[leftIndex];
            leftIndex++;
            mergeIndex++;
        }

        // Copy the merged and sorted elements back into the original array
        // This replaces the original unsorted segment [start...end]
        for (int index = 0; index < mergedSubArray.length; index++) {
            data[start + index] = mergedSubArray[index];
        }
    }

}
