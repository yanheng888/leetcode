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
    TreeNode lastNode = null;
    TreeNode ret = null;


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return ret;
    }
    
    public boolean dfs(TreeNode root, TreeNode p){
        if(root == null){
            return false;
        }
        if(dfs(root.left, p)){
            return true;
        };
        if(lastNode == p){
            ret = root;
            return true;
        }
        lastNode = root;
        if(dfs(root.right, p)){
            return true;
        };
        return false;
        
    }
}
