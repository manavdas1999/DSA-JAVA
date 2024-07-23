class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // IDEA: Cycle Sort: array of range[1,n]
        // Time: O(n), Space: O(1) (returning list is not counted)

        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i+1){
                // element at wrong index
                int correctIndex = nums[i]-1;
                if(nums[correctIndex] == nums[i]){
                    // if correct index position is already occupied with correct value
                    // then duplicate found but skip it as we cannot collect them now
                    // as it will cause duplicate values in list.
                    i++;
                    continue;
                }
                else{
                    // not duplicate
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

        // Traversing the list again to find abnormal values(i.e duplicate values)
        i = 0;
        while(i < nums.length){
            if(nums[i] != i+1) list.add(nums[i]);
            i++;
        }
        return list;
    }
}
