class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(""), n, 0, 0);
        return res;
    }
    private void backtrack(List<String> res, StringBuilder curr, int n, int open, int close){
        if(open == n && close == n){
            res.add(curr.toString());
            return;
        } 
        if(open < n){
            curr.append("(");
            backtrack(res, curr, n, open+1, close);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close < n && close < open){
            curr.append(")");
            backtrack(res, curr, n, open, close+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}