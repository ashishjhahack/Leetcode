/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
    private int solve(TreeNode root){
        if(root == null) return 0;

        // Hypothesis part
        // If negative, ignore it.
        int l = Math.max(0, solve(root.left));
        int r = Math.max(0, solve(root.right));

        // Induction
        int currPath = l + root.val + r;
        // Update global answer
        maxSum = Math.max(maxSum, currPath);

        // Return the best ONE-SIDED path
        // because parent can only continue through
        // one branch.
        return root.val + Math.max(l, r);
    }
}