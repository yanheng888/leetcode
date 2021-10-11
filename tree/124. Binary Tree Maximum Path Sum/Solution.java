

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
    Integer ret = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        rec(root);
        return ret;
    }

    private int rec(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftSum =  Math.max(0, rec(root.left));
        int rightSum = Math.max(0, rec(root.right));
        
        ret = Math.max(ret, leftSum + rightSum + root.val);
    
        return Math.max(leftSum, rightSum) + root.val;

        
    }
}
