class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n <= 2) return 0;
        int[] maxLeft = new int[n];   // find max building in left
        int[] maxRight = new int[n];  // find max building in right
        
        // 1. Build prefix max (tallest block to the left including itself)
        maxLeft[0] = height[0];
        for(int i=1; i<n; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }
        
        // 2. Build suffix max (tallest block to the right including itself)
        maxRight[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }
        
        // Find total
        int totWaterArea = 0;
        for(int i = 0; i<n; i++){
            totWaterArea += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return totWaterArea;
    }
}