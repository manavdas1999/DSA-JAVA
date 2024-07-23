class Solution {
    public int findDuplicate(int[] nums) {
        // IDEA: Cycle sort - array of range [1,n]
        // Time: O(n), space: O(1)

        // other ways can be a set or boolean visited array
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i+1){
                // element at wrong index
                int correctIndex = nums[i]-1;
                if(nums[correctIndex] == nums[i]){
                    // if correct index already contains the right value, then it must be a duplicate
                    return nums[i];
                }
                else{
                    // if not duplicate
                    int temp = nums[correctIndex];
                    nums[correctIndex] = nums[i];
                    nums[i] = temp;
                }
            }
            else{
                // element at correct index
                i++;
            }
        }

        // if no duplicate found
        return 0;
    }
}
