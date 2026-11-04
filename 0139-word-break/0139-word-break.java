class Solution {
    public boolean wordBreak(String s, List<String> wordDict){  // T.C->O(n^3), S.C->O(n)
        int n = s.length();
        HashSet<String> hst = new HashSet<>(wordDict);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return recur(0, s, hst, dp);
    }
    private boolean recur(int index, String s, HashSet<String> hst, int[] dp){
        if(index == s.length()) return true;
        
        if(dp[index] != -1){
            return dp[index] == 1; 
        }

        for(int i  = index+1; i<=s.length(); i++){ // index -> starting point, i -> ending point
            String word = s.substring(index, i);
            if(hst.contains(word) && recur(i, s, hst, dp)){
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = 0;
        return false;
    }
}