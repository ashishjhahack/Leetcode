import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n-2; i++){    // first fix the first element
            int left = i+1;
            int right = nums.length-1;
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if(sum < 0){  // if sum less than zero than search for a greater value
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
