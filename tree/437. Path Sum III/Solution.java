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
    int cnt = 0;
    public int pathSum(TreeNode root, int targetSum) {
        cnt = 0;
        dfs(root, targetSum);
        return cnt;
    }

    private void dfs(TreeNode root, int targetSum) {
        if(root == null){
            return ;
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        cnt += targetPathNum(root, targetSum);
    }

    private int targetPathNum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        if(targetSum == root.val){
            return 1 + targetPathNum(root.left, 0) +
                    targetPathNum(root.right, 0);
        }else{
            return targetPathNum(root.left, targetSum - root.val) +
                    targetPathNum(root.right, targetSum - root.val);
        }

    }
}
