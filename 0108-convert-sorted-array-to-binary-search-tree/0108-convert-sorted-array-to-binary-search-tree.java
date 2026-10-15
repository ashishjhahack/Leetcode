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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return buildBST(nums, 0, n-1);
    }
    public TreeNode buildBST(int[] nums, int left, int right){
        // Base case
        if(left > right){
            return null;
        }
        // Divide: by taking root
        int mid = left + (right-left)/2;
        // Conquer
        TreeNode root = new TreeNode(nums[mid]);

        // Traverse left and right subtree recursively
        root.left = buildBST(nums, left, mid-1);
        root.right = buildBST(nums, mid+1, right);

        return root;
    }
}