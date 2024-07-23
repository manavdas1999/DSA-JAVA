class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // IDEA: Cycle sort - as given array is from range[1,n]
        // Time: O(n), Space: O(1) returning list is not extra space

        // Another solution could be using a boolean visited array of size n+1; space: O(n)

        // sorting the array first
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i+1){
                // element at wrong index
                int correctIndex = nums[i]-1;
                if(nums[correctIndex] == nums[i]){
                    // if it is already occupied with correct value(as we have duplicates in input array)
                    // skip it
                    i++;
                    continue;
                }
                else{
                    // swap values with correct position
                    int temp = nums[correctIndex];
                    nums[correctIndex] = nums[i];
                    nums[i] = temp; 
                }
            }
            else{
                // if element at right position
                i++;
            }
        }

        // traversing the array again to find the abnormal values(nums[i] != i+1) i.e missing values
        i = 0;
        List<Integer> list = new ArrayList<>();
        while(i < nums.length){
            // adding missing values(i+1) to list
            if(nums[i] != i+1) list.add(i+1);
            i++;
        }

        return list;
    }
}
