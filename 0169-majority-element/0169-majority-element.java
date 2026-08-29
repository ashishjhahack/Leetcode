class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            if (count > majorityCount) {
                return num;
            }
            countMap.put(num, count);
        }

        throw new IllegalArgumentException("No majority element found");
    
    }
}