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
    int xDep = 0;
    int yDep = 0;
    int xPar = 0;
    int yPar = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, root.val);
        return (xDep == yDep) && (xPar != yPar);
    }
    
    public void dfs(TreeNode root, int x, int y, int dep, int par){
        if(root == null){
            return ;
        }
        dfs(root.left, x , y, dep + 1, root.val);
        dfs(root.right, x , y, dep + 1, root.val);
        if(root.val == x){
            xDep = dep;
            xPar = par;
        }
        if(root.val == y){
            yDep = dep;
            yPar = par;
        }
    }
}
