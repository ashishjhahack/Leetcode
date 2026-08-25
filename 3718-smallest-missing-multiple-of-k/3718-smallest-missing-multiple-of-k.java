class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> hst = new HashSet<>();
        for(int num: nums) hst.add(num);
        
        int multiple = k;
        while(hst.contains(multiple)){
            multiple += k;
        }
        return multiple;
    }
}