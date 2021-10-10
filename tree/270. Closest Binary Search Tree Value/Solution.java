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
    public int closestValue(TreeNode root, double target) {
        int ret = Integer.MAX_VALUE;
        while(root != null){
            if(root.val == target){
                return root.val;
            }
            if(Math.abs(root.val - target) < Math.abs(ret - target)){
                ret = root.val;
            }
            if(root.val < target){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return ret;
    }
}
