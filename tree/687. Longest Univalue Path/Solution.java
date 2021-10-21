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
    int ret;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        ret = 0;
        dfs(root);
        return ret - 1;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int LL = 0;
        int RR = 0;
        if(root.left != null && root.val == root.left.val){
            LL = left;
        }
        if(root.right != null && root.val == root.right.val){
            RR = right;
        }
        ret = Math.max(ret, LL + RR + 1);
        //因为是一条path,不能拐弯，所以返回左子树或右子树的最大+1
        return Math.max(LL+1, RR+1);
    }

}
