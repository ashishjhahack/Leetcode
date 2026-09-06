class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        HashMap<Integer, Integer> hmp = new HashMap<>();   // (value, index)
        for(int i=0; i<n; i++){
            int partner = target - nums[i];
            if(hmp.containsKey(partner)){
                ans[0] = hmp.get(partner);  // get value(index)
                ans[1] = i;
                return ans;
            }
            else hmp.put(nums[i], i);
        }
        return ans;
    }
}