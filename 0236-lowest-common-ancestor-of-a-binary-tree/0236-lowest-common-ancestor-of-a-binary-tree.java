/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // handle 2nd & 3rd condition
        if(root == null || root == p || root == q){  
            return root;
        }
        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);

        // handles 4th condition where one of them is null
        if(leftChild == null) return rightChild;
        else if(rightChild == null) return leftChild;

        // handles 5th condition
        else return root;
    }
}