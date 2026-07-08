class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1};
        HashMap<Integer, Integer> hmp = new HashMap<>();    // value, index

        for(int i = 0; i<n; i++){
            int partner = target - nums[i];
            if(hmp.containsKey(partner)){
                ans = new int[]{hmp.get(partner), i};
                return ans;
            }
            else{
                hmp.put(nums[i], i);
            }
        }
        return ans;
    }
}