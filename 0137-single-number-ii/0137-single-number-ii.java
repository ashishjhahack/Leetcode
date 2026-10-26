class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hmp = new HashMap<>();
        for(int num: nums){   // put element in hashmap
            hmp.put(num, hmp.getOrDefault(num, 0)+1);
        }
        for(int i=0; i<nums.length; i++){
            if(hmp.get(nums[i]) == 1) return nums[i];
        }
        return -1;
    }
}