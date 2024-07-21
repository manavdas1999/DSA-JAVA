// Sorting Algorithm : Selection sort
// Time: O(n^2) in all cases
// Space: O(1) (In-place sorting algo)
// Not a Stable sorting algo. (order of duplicates is not maintained)

import java.util.Arrays;

class HelloWorld {
    
    public static void selectionSort(int[] arr){
        int n = arr.length;
        // Pass : n-1 times
        for(int i = 1; i <= n-1; i++){
            // finding maximum from unsorted values in each pass
            int maxIndex = 0;
            for(int j = 1; j <= n-i; j++){
                if(arr[maxIndex] < arr[j]) maxIndex = j;
            }
            // max on each pass goes to the end by swapping
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[n-i];
            arr[n-i] = temp;

        }
    }
    
    
    public static void main(String[] args) {
        int[] nums = new int[]{6,5,4,3,2,1};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    

}
