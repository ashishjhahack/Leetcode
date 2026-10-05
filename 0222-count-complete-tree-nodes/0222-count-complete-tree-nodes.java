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
class Solution {  // Time  = O(log² n) , space = O(log n)
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // If left and right heights are equal,
        // the tree is perfect and we can find using only formulae
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight)-1;
        }

        // Otherwise, recursively count both subtrees.
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    private int getRightHeight(TreeNode root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.right;
        }

        return height;
    }
}