class Solution {
    public int[] productExceptSelf(int[] nums) {  // Eg. nums = [1,2,3,4]
        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for(int i = 1; i<n; i++){   // left = [1,1,2,6]
            left[i] = left[i-1]*nums[i-1];
        }

        right[n-1] = 1;
        for(int i = n-2; i>=0; i--){   // right = [24, 12, 4, 1]
            right[i] = right[i+1]*nums[i+1];
        }

        // combine left and right product
        for(int i=0; i<n; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }
}