class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(0, curr, res, candidates, target);

        return res;
    }
    private void backtrack(int index, List<Integer> curr, List<List<Integer>> res, int[] candidates, int target){
        // base case
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(index == candidates.length) return;

        // pick
        if(candidates[index] <= target){
            curr.add(candidates[index]);
            backtrack(index, curr, res, candidates, target-candidates[index]);
            curr.remove(curr.size()-1);
        }
        // No pick
        backtrack(index+1, curr, res, candidates, target);
    }
}