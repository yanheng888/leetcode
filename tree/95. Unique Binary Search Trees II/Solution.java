import java.util.ArrayList;
import java.util.List;

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
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    private List<TreeNode> dfs(int start,int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        if(start==end){
            res.add(new TreeNode(start));
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftNodes = dfs(start,i-1);
            List<TreeNode> rightNodes = dfs(i+1,end);
            for(TreeNode lNode:leftNodes){
                for(TreeNode rNode:rightNodes){
                    res.add(new TreeNode(i,lNode,rNode));
                }
            }
        }
        return res;
    }
}