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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        targetSum -= root.val;   // Subtract curr node's value

        if(root.left == null && root.right == null){   // It means leaf node
            return targetSum == 0;   // means true
        }

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}