class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return recur(0, -1, nums, dp);
    }
    private int recur(int index, int prev, int[] nums, int[][] dp){
        // means we have processed all elements of the array
        if(index == nums.length) return 0;

        // memoization check
        if(dp[index][prev+1] != -1){
            return dp[index][prev+1];
        }

        int pick = 0;
        if(prev == -1 || nums[index] > nums[prev]){  // pick the elemnt when it is first time 
            pick = 1 + recur(index+1, index, nums, dp);  // change the prev to index
        }
        int noPick = recur(index+1, prev, nums, dp);
        dp[index][prev+1] = Math.max(pick, noPick);
        return dp[index][prev+1];
    }
}