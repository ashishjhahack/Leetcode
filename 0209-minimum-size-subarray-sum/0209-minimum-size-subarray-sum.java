class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int windowSt = 0;
        int windowEnd = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int len = 0;
        while(windowEnd < n){
            // Expansion phase
            sum += nums[windowEnd];
            if(sum >= target){
                len = windowEnd - windowSt + 1;
                minLen = Math.min(minLen, len);

                // Shrinking Phase
                while(windowSt < windowEnd && sum >= target){
                    // remove starting to find min subarray
                    sum -= nums[windowSt];
                    windowSt++;

                    if(sum >= target){   // after removing
                        len = windowEnd - windowSt + 1;
                        minLen = Math.min(minLen, len);
                    }
                }
            }
            windowEnd++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}