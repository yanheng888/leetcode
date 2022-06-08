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
    int[] mat;
    public List<Integer> rightSideView(TreeNode root) {
        mat = new int[100];
        for(int i=0;i<100;i++){
            mat[i] = 101;
        }
        dfs(root,0);
        ArrayList<Integer> res = new ArrayList();
        for(int i=0;i<100;i++){
            if(mat[i] == 101){
                continue;
            }
            res.add(mat[i]);
        }
        return res;
    }
    public void dfs(TreeNode root,int lev){
        if(root == null){
            return;
        }
        dfs(root.left,lev+1);
        mat[lev] = root.val;
        dfs(root.right,lev+1);
    }
}
