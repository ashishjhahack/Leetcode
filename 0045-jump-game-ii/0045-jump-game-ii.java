class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n==0 || n==1) return 0;

        int maxIndex = 0;
        int currEnd = 0;
        int countJump = 0;
        for(int i = 0; i<n; i++){
            maxIndex = Math.max(maxIndex, i+nums[i]);
            if(i == currEnd){// we only make jump if distance is reachable
                countJump++;
                currEnd = maxIndex;
            }
            if(currEnd >= n-1){
                break;
            }
        }
        return countJump;
    }
}