class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1, max = 0;
        while(l<r){
            int lh = height[l];
            int rh = height[r];

            int min_h = Math.min(lh, rh);
            max = Math.max(max, min_h*(r-l));

            if(lh<rh) l++;
            else r--;
        }
        return max;
    }
}