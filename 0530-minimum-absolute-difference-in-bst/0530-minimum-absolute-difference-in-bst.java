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
    // use inorder b/c it gives BST in sortde order

    TreeNode prev = null;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left); // first traverse left unitl get null
        
        // then starts getting min diff
        if(prev != null){
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;  // update prev = curr node

        inorder(root.right);
    }
}