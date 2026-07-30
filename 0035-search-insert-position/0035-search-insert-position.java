class Solution {
    public int searchInsert(int[] nums, int target) {   // lower bound approach
        int n= nums.length;
        int i = 0, j = n-1;
        int ans = n;
        
        while(i <= j){
           int mid = i + (j-i)/2;
           if(nums[mid] >= target){
            ans = mid;
            j = mid-1;
           } 
           else{
            i = mid+1;
           }
        }
        return ans;
    }
}