import java.util.ArrayList;

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
    TreeNode pre = null;
    int cnt = 1;
    int modeFreq = 1;
    ArrayList<Integer> modes = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        modes.clear();
        dfs(root);
        int[] ret = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++){
            ret[i] = modes.get(i);
        }
        return ret;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        if(pre != null){
            if(pre.val == root.val){
                cnt++;
            }else{
                cnt = 1;
                pre = root;
            }
        }else{
            pre = root;
        }
        
        if(cnt > modeFreq){
            modes.clear();
            modes.add(root.val);
            modeFreq = cnt;
        }else if(cnt == modeFreq){
            modes.add(root.val);
        }
        dfs(root.right);
    }


}
