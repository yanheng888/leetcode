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

    private List<TreeNode> dfs(int start, int end) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        if(start > end){
            arr.add(null);
            return arr;
        }
        if(start == end){
            arr.add(new TreeNode(start));
            return arr;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftTree = dfs(start, i - 1);
            List<TreeNode> rightTree = dfs(i + 1, end);
            for(TreeNode lNode: leftTree){
                for(TreeNode rNode: rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    arr.add(root);
                }
            }
        }
        return arr;
    }
}
