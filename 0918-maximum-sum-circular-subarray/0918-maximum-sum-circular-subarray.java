class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int totSum = nums[0];
        int currMin = nums[0], minSum = nums[0];
        int currMax = nums[0], maxSum = nums[0];

        for(int i=1; i<n; i++){
            totSum += nums[i];
            // Step-1: find the minSum and maxSum
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(minSum, currMin);

            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(currMax, maxSum);
        }
        // means if in array every element is -ve then we return max out of it
        if(maxSum < 0) return maxSum;

        return Math.max(maxSum, totSum - minSum);
    }
}