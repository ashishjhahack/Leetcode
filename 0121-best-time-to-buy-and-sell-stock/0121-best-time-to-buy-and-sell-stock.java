class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int minSoFar = prices[0];

        for(int i = 1; i<n; i++){
            minSoFar = Math.min(minSoFar, prices[i]);
            res = Math.max(res, prices[i] - minSoFar);
        }
        return res;
    }
}