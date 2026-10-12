class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPerms(nums, 0, ans);
        return ans;
    }
    public void getPerms(int[] nums, int idx, List<List<Integer>> ans){
        // Base case
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num: nums){
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for(int i = idx; i<nums.length; i++){

            // swap (choose)
            swap(nums, idx, i);

            // recurse
            getPerms(nums, idx+1, ans);

            // swap (undo)
            swap(nums, idx, i);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}