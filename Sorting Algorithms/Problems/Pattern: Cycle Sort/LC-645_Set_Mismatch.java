class Solution {
    public int[] findErrorNums(int[] nums) {
        // IDEA: Cycle sort: array range [1,n]
        // Time: O(n), Space: O(1)

        int i = 0;
        while(i < nums.length){
            if(nums[i] != i+1){
                // element at wrong position
                int correctIndex = nums[i]-1;
                if(nums[correctIndex] == nums[i]){
                    // if duplicate value, correct index already filled with correct value
                    // skip it
                    i++;
                    continue;
                }
                else{
                    int temp = nums[correctIndex];
                    nums[correctIndex] = nums[i];
                    nums[i] = temp;
                }
            }
            else{
                // element at right position
                i++;
            }
        }

        // traverse the array to find abnorml value(i.e duplicate and missing value)
        i = 0;
        while(i < nums.length){
            if(nums[i] != i+1) return new int[]{nums[i], i+1};
            i++;
        }
        // if no mis match found
        return null;
    }
}
