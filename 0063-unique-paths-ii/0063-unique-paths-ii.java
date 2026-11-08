class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] dp = new Integer[m][n];

        return recur(0, 0, obstacleGrid, dp);
    }
    private int recur(int i, int j, int[][] obstacleGrid, Integer[][] dp){
        // Out of Bound Case for handeling grid
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length) return 0;

        // Handle obstacle
        if(obstacleGrid[i][j] == 1) return 0;

        // Base case : reach to the destination
        if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1){
            return 1;
        }

        // memoization check
        if(dp[i][j] != null) return dp[i][j];
        
        int down = recur(i+1, j, obstacleGrid, dp);
        int right = recur(i, j+1, obstacleGrid, dp);
        dp[i][j] =  down + right;   // return total path by adding it
        return dp[i][j];
    }
}