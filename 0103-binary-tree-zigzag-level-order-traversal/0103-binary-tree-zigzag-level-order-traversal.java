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
    // Function to find the max height of the tree
    public static int maxHeight(TreeNode root) {
        if (root == null) return 0;  // Base case: empty node, height 0
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1; // Max depth of left/right subtrees
    }

    // Helper function to collect nodes at a particular level
    public static void collectLevel(TreeNode root, int n, List<Integer> arr, boolean leftToRight) {
        if (root == null) return;
        
        // If we've reached the level, add the node to the list
        if (n == 1) {
            arr.add(root.val);
            return;
        }

        // Traverse based on the direction (left to right or right to left)
        if (leftToRight) {
            collectLevel(root.left, n - 1, arr, leftToRight);
            collectLevel(root.right, n - 1, arr, leftToRight);
        } else {
            collectLevel(root.right, n - 1, arr, leftToRight);
            collectLevel(root.left, n - 1, arr, leftToRight);
        }
    }

    // Main function to perform zigzag level order traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = maxHeight(root);  // Get the height of the tree

        // Perform level-order traversal
        for (int i = 1; i <= n; i++) {
            List<Integer> arr = new ArrayList<>();
            boolean leftToRight = (i % 2 == 1);  // Alternate direction every level
            collectLevel(root, i, arr, leftToRight);  // Collect nodes at level i
            ans.add(arr);
        }
        
        return ans;
    }
}
