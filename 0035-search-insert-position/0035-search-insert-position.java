class Solution {
    public int searchInsert(int[] nums, int target) {
        int n= nums.length;
        int i = 0, j = n-1;

        while(i <= j){
            int mid = i + (j - i)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return i;   // If target not found
    }
}