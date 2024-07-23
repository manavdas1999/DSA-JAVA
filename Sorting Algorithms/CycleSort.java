// Sorting : Cycle Sort
// Time: O(n), Space: O(1)
// Note: applicable only for arrays with values 1-n, where n is length of array
// Use Case: used as a pattern in DSA problems.
import java.util.Arrays;
class HelloWorld {
    public static void main(String[] args) {
        int[] nums = {3,2,1,4,5};
        cycleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public static void cycleSort(int[] arr){
        int i = 0;
        while(i < arr.length-1){
            if(arr[i] == i+1){
                // value at right position
                i++;
            }
            else{
                // value not at right position
                // swap the value to its right position which is index = arr[i]-1
                int correctIndex = arr[i] - 1; // correct index of arr[i]
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
