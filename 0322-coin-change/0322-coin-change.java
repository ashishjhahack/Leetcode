class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        int ans = recur(n-1, coins, amount, dp);
        return ans == Integer.MAX_VALUE-1 ? -1 : ans;
    }
    private int recur(int index, int[] coins, int target, int[][] dp){
        // Base Case
        if(index == 0){
            if(target % coins[0] == 0) return target/coins[0];
            return Integer.MAX_VALUE-1;
        }
        // Memoization check
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        int pick = Integer.MAX_VALUE;
        if(coins[index] <= target){
            // using 1 b/c we increase coin count by 1
            pick = 1 + recur(index, coins, target-coins[index], dp);
        }
        int noPick = recur(index-1, coins, target, dp);
        dp[index][target] = Math.min(pick, noPick);
        return dp[index][target];
    }
}