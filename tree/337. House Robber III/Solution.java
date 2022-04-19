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
    HashMap<TreeNode,Integer> flag0;
    HashMap<TreeNode,Integer> flag1;
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        flag0 = new HashMap();
        flag1 = new HashMap();
        int option1 = dfs(root.left,0)+dfs(root.right,0);
        int option2 = root.val+dfs(root.left,1)+dfs(root.right,1);
        return Math.max(option1,option2);
    }
    public int dfs(TreeNode root,int flag){
        if(root == null){
            return 0;
        }
        if(flag == 1 && flag1.containsKey(root)){
            return flag1.get(root);
        }
        if(flag == 0 && flag0.containsKey(root)){
            return flag0.get(root);
        }
        int res = 0;
        if(flag == 1){
            res = dfs(root.left,0)+dfs(root.right,0);
        }else{
            int option1 = root.val+dfs(root.left,1)+dfs(root.right,1);
            int option2 = dfs(root.left,0)+dfs(root.right,0);
            res = Math.max(option1,option2);
        }
        if(flag==0){
            flag0.put(root,res);
        }else{
            flag1.put(root,res);
        }
        return res;
    }
}
