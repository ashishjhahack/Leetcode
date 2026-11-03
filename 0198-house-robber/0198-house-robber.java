class Solution {
    public int rob(int[] nums) {   // use pick/no-pick logic
        int n = nums.length;

        if(n == 0) return 0;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return recur(nums, n-1, dp);
    }
    private int recur(int[] nums, int index, int[] dp){
        if(index == 0) return nums[0];
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + recur(nums, index-2, dp);    // if pick then take 2 steps back
        int noPick = 0 + recur(nums, index-1, dp);  // only take 1 steps back

        dp[index] = Math.max(pick, noPick);
        return dp[index];
    }
}