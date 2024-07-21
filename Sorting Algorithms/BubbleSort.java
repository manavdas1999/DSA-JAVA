// Sorting Algorithm : Bubble sort
// Time: best(sorted already) O(n) (if apply swapped flag)
//       worst(reverse sorted) O(n^2) 
// Space: O(1) (In-place sorting algo)
// Stable sorting algo. (order of duplicates is maintained)

import java.util.Arrays;

class HelloWorld {
    
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped; // to reduce time for best case from O(n^2) to O(n)
        // Pass : n-1 times
        for(int i = 1; i<=n-1; i++){
            swapped = false;
            // Comparisons : n-i times
            for(int j = 0; j<n-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            
            // if no swapping done in a pass, i.e array already sorted
            if(!swapped) break;
        }
    }
    
    
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6, 1, 2, 3};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    

}
