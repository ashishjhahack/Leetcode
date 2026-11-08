class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;   // row length
        int n = grid[0].length;    // col length
        Integer[][] dp = new Integer[m][n];
        return recur(0, 0, grid, dp);
    }
    private int recur(int i, int j, int[][] grid, Integer[][] dp){  
        // you can't move diagonally. OS, there's also two choice available
        // Out of bounds
        if (i >= grid.length || j >= grid[0].length) {
            return 1_000_000_000;
        }
        // base case
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        // Memoization check
        if(dp[i][j] != null) return dp[i][j];
        // move down
        int down = grid[i][j] + recur(i+1, j, grid, dp);
        // move right
        int right = grid[i][j] + recur(i, j+1, grid, dp);

        dp[i][j] = Math.min(down, right);
        return dp[i][j];
    }
}