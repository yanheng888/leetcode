import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
    HashSet<Integer> leafNodes = new HashSet<>();
    HashMap<Integer, TreeNode> val2Root = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    TreeNode pre = null;
    public TreeNode canMerge(List<TreeNode> trees) {
        int n = trees.size();
        for(int i = 0; i < n; i++){
            TreeNode node = trees.get(i);
            val2Root.put(node.val, node);
            addLeaf(node.left);
            addLeaf(node.right);
        }
        int cnt = 0;
        TreeNode root = null;
        for(int i = 0; i < n; i++){
            TreeNode node = trees.get(i);
            if(!leafNodes.contains(node.val)){
                root = node;
                cnt++;
            }
        }
        if(cnt != 1){
            return null;
        }
        visited.add(root.val);
        if(dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, root) && visited.size() == n ){
            return root;
        }else{
            return null;
        }
    }

    private boolean dfs(TreeNode root, int maxValue, int minValue, int flag, TreeNode pre) {
        if(root == null){
            return true;
        }
        int val = root.val;
        if(val > maxValue || val < minValue){
            return false;
        }
        if(root.left != null || root.right != null){
            return dfs(root.left, val - 1, minValue, -1, root) && dfs(root.right, maxValue, val + 1, 1, root);
        }else if(val2Root.containsKey(val)){
            TreeNode node = val2Root.get(val);
            this.visited.add(val);
            if(flag == -1){
                pre.left = node;
            }else if(flag == 1){
                pre.right = node;
            }
            return dfs(node.left, node.val - 1, minValue, -1, node) && dfs(node.right, maxValue, node.val + 1, 1, node);
        }
        return true;
    }

    private void addLeaf(TreeNode root) {
        if(root == null){
            return;
        }
        leafNodes.add(root.val);
        addLeaf(root.left);
        addLeaf(root.right);
    }
}
