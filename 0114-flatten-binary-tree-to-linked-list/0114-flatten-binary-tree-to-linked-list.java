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
    TreeNode nextRight = null;  // b/c it changes to this with every recursive call that's why we declare this outside the function

    public void flatten(TreeNode root) {
        if(root == null) return;


        // traverse tree
        flatten(root.right);   // first traverse right subtree
        flatten(root.left);    // then traverse left subtree

        // converting to linkedlist
        root.left = null;
        root.right = nextRight;   // connect nodes
        nextRight = root;   // update the root and stores this previous node value
    }
}