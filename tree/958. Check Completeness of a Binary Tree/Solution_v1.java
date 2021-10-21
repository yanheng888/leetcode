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
    public boolean isCompleteTree(TreeNode root) {
        //计算tree nodes 数量
        int nodesNum = countNodesNum(root);
        return dfs(root, 0, nodesNum);
    }

    private boolean dfs(TreeNode root, int val, int nodesNum) {
        if(root == null){
            return true;
        }
        if(val >= nodesNum){
            return false;
        }
        return dfs(root.left, val * 2 + 1, nodesNum) && dfs(root.right, val * 2 + 2, nodesNum);

    }

    private int countNodesNum(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + countNodesNum(root.left) + countNodesNum(root.right);
    }

}
