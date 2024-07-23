class Solution {
    public int firstMissingPositive(int[] nums) {
        // IDEA: Cyclic sort, hard to detect but hints can be that we are only concerned with 
        // positive numbers and value range [1, n], hence if we skip zeros, negative values and values > n
        // it is essentially to find first missing value in an array of range [1, n]

        int i=0;
        while(i < nums.length){
            if(nums[i] != i+1){
                // element at wrong position
                int correctIndex = nums[i]-1;
                if(nums[i] <= 0 || nums[i] > nums.length || nums[correctIndex] == nums[i]){
                    // skip negatives, zeroes, values > size and duplicates
                    i++;
                    continue;
                }
                else{
                    // valid value 
                    int temp = nums[correctIndex];
                    nums[correctIndex] = nums[i];
                    nums[i] = temp;
                }
            }
            else{
                // element at correct position
                i++;
            }
        }

        // traversing again to find first missing positive
        i = 0;
        while(i < nums.length){
            if(nums[i] != i+1) return i+1;
            i++;
        }

        return i+1; // if nothing is missing in array that means the next positive value is missing(i.e n+1)
    }
}
