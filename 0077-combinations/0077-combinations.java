class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(1, n, k, curr, res);

        return res;
    }
    private void backtrack(int st, int n, int k, List<Integer> curr, List<List<Integer>> res){
        // base case
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = st; i<=n; i++){
            curr.add(i);
            backtrack(i+1, n, k, curr, res);
            curr.remove(curr.size() - 1); // backtrack
        }
    }
}