class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        
        return recur(0, 0, triangle, dp);
    }
    private int recur(int i, int j, List<List<Integer>> triangle, Integer[][] dp){
        // Base case: if reached the end row
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        // Memoization check
        if(dp[i][j] != null) return dp[i][j];
        // move down
        int down = triangle.get(i).get(j) + recur(i+1, j, triangle, dp);
        // move diagonal
        int diagonal = triangle.get(i).get(j) + recur(i+1, j+1, triangle, dp);

        dp[i][j] =  Math.min(down, diagonal);
        return dp[i][j];
    }
}