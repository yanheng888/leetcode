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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null){
            return root == subRoot;
        }
        if(isSame(root, subRoot)){
            return true;
        }else{
            return isSame(root.left, subRoot) || isSame(root.right, subRoot);
        }
    }
    
    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root == null || subRoot == null){
            return root == subRoot;
        }
        if(root.val != subRoot.val){
            return false;
        }
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}
