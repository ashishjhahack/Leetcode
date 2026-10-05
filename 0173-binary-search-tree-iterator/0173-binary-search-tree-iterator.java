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
class BSTIterator {
    Stack<TreeNode> st;
    void storeLeftNodes(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        storeLeftNodes(root);
    }
    
    public int next() {
        TreeNode ans = st.peek();
        st.pop();
        storeLeftNodes(ans.right);   // if right present in currNode then move to right
        return ans.val;
    }
    
    public boolean hasNext() {
        return st.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */