class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        getPerms(nums, curr, ans);
        return ans;
    }
    public void getPerms(int[] nums, List<Integer> curr, List<List<Integer>> ans){
        // Base case
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            // if already contain it then skip it
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);  // otherwise add it
            getPerms(nums, curr, ans);
            // remove it(backtrack)
            curr.remove(curr.size()-1);
        }
    }
}