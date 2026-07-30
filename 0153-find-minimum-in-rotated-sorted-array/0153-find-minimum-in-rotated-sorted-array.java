class Solution {
    public int findMin(int[] nums) {
        // the approach is same as "find kth rotation"
        int n = nums.length;
        int low = 0, high = n-1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){// mid is greater so we know, we find smaller in right side
                low = mid+1;
            }
            else high = mid;     // low == mid
        }
        return nums[low];
    }
}