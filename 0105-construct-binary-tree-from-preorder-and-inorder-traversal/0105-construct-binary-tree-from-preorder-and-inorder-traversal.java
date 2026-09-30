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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1. Pick root from preorder
        // 2. Find root in inorder using hashMap
        // 3. Everything left → left subtree
        // 4. Everything right → right subtree
        // 5. Recursively construct both
        HashMap<Integer, Integer> hmp = new HashMap<>();
        int n = preorder.length-1, m = inorder.length-1;
        for(int i=0; i<inorder.length; i++){
            hmp.put(inorder[i], i);
        }
        TreeNode root = constructTree(preorder, inorder, hmp, 0, n, 0, m);
        return root; 
    }
    public TreeNode constructTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> hmp, int preStInd, int preEndInd, int inStInd, int inEndInd){

        // Base case
        if(preStInd > preEndInd || inStInd > inEndInd){
            return null;
        }
        // get root index based on preorder
        int rootData = preorder[preStInd];
        int rootIndex = hmp.get(rootData);
        // Create a root
        TreeNode root = new TreeNode(rootData);

        // find left and right based on InOrder
        int leftTreeSize = rootIndex - inStInd;
        int rightTreeSize = inEndInd - rootIndex;

        root.left = constructTree(preorder, inorder, hmp, preStInd+1, preStInd + leftTreeSize,
            inStInd, rootIndex-1);
        root.right = constructTree(preorder, inorder, hmp, preStInd + leftTreeSize + 1, preStInd + leftTreeSize + rightTreeSize, rootIndex+1, inEndInd);

        return root;
    }
}