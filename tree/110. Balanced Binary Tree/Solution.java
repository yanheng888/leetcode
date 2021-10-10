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
    public boolean isBalanced(TreeNode root) {
        if(dfs(root) == -1){
            return false;
        }
        return true;
    }
    
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        if(Math.abs(leftHeight - rightHeight) >= 2 || leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
