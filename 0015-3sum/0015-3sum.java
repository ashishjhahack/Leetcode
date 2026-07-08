import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n-2; i++){    // first fix the first element

            // Skip the duplicates vlaue for a first element
            if(i>0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length-1;
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // Skip duplicate values from the left
                    while (left < right && nums[left] == nums[left - 1])
                        left++;

                    // Skip duplicate values from the right
                    while (left < right && nums[right] == nums[right + 1])
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
        return res;
    }
}
