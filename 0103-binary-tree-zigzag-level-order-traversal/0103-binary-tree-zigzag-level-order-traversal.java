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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // first one is always false and their next will true
        boolean rev = false;   // we can use odd-even too

        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0; i<level; i++){
                TreeNode currNode = q.poll();
                currLevel.add(currNode.val);

                // Add children
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
            if(rev) Collections.reverse(currLevel);
            ans.add(currLevel);
            rev = !rev;
        }
        return ans;
    }
}
