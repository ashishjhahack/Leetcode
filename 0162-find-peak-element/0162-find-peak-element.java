class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;    // return index of only one element

        // Check the first and last elements separately
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int left = 1, right = n - 2; // Avoid out-of-bounds issues
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Peak condition
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) 
                return mid;

            // Move right if mid is increasing
            else if (nums[mid] < nums[mid + 1]) 
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return -1; // This won't be reached due to problem constraints
    }
}
