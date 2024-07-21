// Sorting Algorithm : Insertion sort
// Time: worst: O(n^2), Best(sorted array) O(n)
// Space: O(1) (In-place sorting algo)
// Stable sorting algo. (order of duplicates is maintained)

import java.util.Arrays;

class HelloWorld {
    
    public static void insertionSort(int[] arr){
        int n = arr.length;
        // Pass : n-1 times
        for(int i = 1; i <= n-1; i++){
            boolean swapped = false; // to optimize best case(sorted) time
            // Comparisons : i times (i to 1)
            for(int j = i; j > 0; j--){
                // comparing adjacent values(in sorted part of array) for smaller 
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
                else break;  // comparisons will happen only till right place of arr[j] is not found
            }
            // if no swaps occur in a pass i.e array is sorted
            if(!swapped) break;

        }
    }
    
    
    public static void main(String[] args) {
        int[] nums = new int[]{6,5,4,3,2,1};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    

}
