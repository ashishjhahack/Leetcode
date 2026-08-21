class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        boolean isDec = true;
        boolean isInc = true;
        for(int i = 1; i<n; i++){
            if(nums[i-1] < nums[i]) isDec = false;  // if increasing then isDec = false
            if(nums[i-1] > nums[i]) isInc = false;  // if decreasing then isInc = false
        }
        return isDec || isInc;
    }
}