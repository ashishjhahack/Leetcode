class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 1;
        for(int i = 1; i<n; i++){      // Copy to index 1, here index = 2
            if(nums[i] != nums[i-1]){ // [0,0,1,1,1,2,2,3,3,4] --> [0,1,1,1,1,2,2,3,3,4]
                nums[index] = nums[i];
                index++;       // nums :- [0,1,2,3,4,2,2,3,3,4]
            }
        }
        return index;
    }
}