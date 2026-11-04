class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        // Base case
        for(int target = 0; target<=amount; target++){
            if(target % coins[0] == 0){
                dp[0][target] = target/coins[0];
            }
            else{
                dp[0][target] = Integer.MAX_VALUE-1;
            }
        }
        for(int index = 1; index < n; index++){
            for(int target = 0; target<=amount; target++){
                int pick = Integer.MAX_VALUE-1;
                if(coins[index] <= target){
                    pick = 1 + dp[index][target-coins[index]];
                }
                int noPick = dp[index-1][target];
                dp[index][target] = Math.min(pick, noPick);
            }
        }
        int ans = dp[n-1][amount];
        return ans == Integer.MAX_VALUE-1 ? -1 : ans;
    }
}