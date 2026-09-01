class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        int i = 0;
        while(i <= maxIndex){  // only traverse if maxIndex greater otherwise false
            maxIndex = Math.max(maxIndex, nums[i] + i);  // update maxIndex 
            if(maxIndex >= n-1){// if val+index >= lastIndex then we can reach to end
                return true;
            }
            i++;
        }
        return false;
    }
}