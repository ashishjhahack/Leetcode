class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            // determine which part is sorted
            if(nums[left] <= nums[mid]){    // left is sorted
                
                // Now check if target lies inside this range 
                if(nums[left] <= target && target < nums[mid])     
                    right = mid-1;
                else     // if target not in left
                    left = mid+1;
            }
            else{
                if(nums[mid] < target && target <= nums[right])
                    left = mid+1;
                else 
                    right = mid-1;
            }
        }
        return -1;
    }
}