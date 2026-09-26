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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;  // b/c both are null. so, its same

        if(p == null || q == null) return false;  // if one of them null

        if(p.val != q.val) return false;   // if values are diff

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}