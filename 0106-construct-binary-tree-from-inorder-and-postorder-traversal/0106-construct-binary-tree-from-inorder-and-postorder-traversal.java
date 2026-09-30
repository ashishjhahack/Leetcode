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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // using postOrder we can also able to find root
        HashMap<Integer, Integer> hmp = new HashMap<>();
        int n = inorder.length-1, m = postorder.length-1;
        for(int i = 0; i<inorder.length; i++){
            hmp.put(inorder[i], i);
        }
        TreeNode root = constructTree(inorder, postorder, hmp, 0, n, 0, m); 
        return root;
    }
    public TreeNode constructTree(int[] inorder, int[] postorder,  HashMap<Integer, Integer> hmp, int inStInd, int inEndInd, int postStInd, int postEndInd){

        // Base case
        if(postStInd > postEndInd || inStInd > inEndInd){
            return null;
        }
        // get root index based on preorder
        int rootData = postorder[postEndInd];
        int rootIndex = hmp.get(rootData);
        // Create a root
        TreeNode root = new TreeNode(rootData);

        // find left and right based on InOrder
        int leftTreeSize = rootIndex - inStInd;
        int rightTreeSize = inEndInd - rootIndex;

        root.left = constructTree(inorder, postorder, hmp,
                inStInd, rootIndex - 1,
                postStInd, postStInd + leftTreeSize - 1);

        root.right = constructTree(inorder, postorder, hmp,
                rootIndex + 1, inEndInd,
                postEndInd - rightTreeSize, postEndInd - 1);

        return root;
    }
}