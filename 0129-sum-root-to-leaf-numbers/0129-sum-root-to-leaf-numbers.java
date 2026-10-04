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
    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }
    private int solve(TreeNode root, int currVal){
        if(root == null) return 0;

        // current val
        currVal = currVal*10 + root.val;

        if(root.left == null && root.right == null) return currVal;

        return solve(root.left, currVal) + solve(root.right, currVal);
    }
}