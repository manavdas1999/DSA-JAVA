class Solution {
    public int missingNumber(int[] nums) {
        // IDEA: Cycle Sort, as array from [0,n] values.
        // Time: O(n), Space: O(1)
        // NOTE: as we have to keep track of value 0 as well, hence we are not using [1,n] cycle sort.
        // sorting the array first
        
        // Other solution can be mathematical, to calculate sum of all values and then subtract it from sum of n whole no.
        
        int i = 0;
        while(i < nums.length){
            if(nums[i] == i){
                // element at right position
                i++;
            }
            else{
                // element not at right position, swap it to right position
                if(nums[i] == nums.length){
                    // i.e nums[i] is n, for which we do not have space in given array
                    // hence skip this case;
                    i++;
                    continue;
                }
                int correctIndex = nums[i]; // correct index of value of nums[i]
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }
        }

        // checking for any abnormal value corresponding to index
        i = 0;
        while(i < nums.length){
            if(nums[i] != i){
                // abnormal value i.e missing value found
                return i;
            }
            i++;
        }

        // if still no abnormal value is found then it means last value (n) is missing
        return i; // i is at n after last loop
    }
}
