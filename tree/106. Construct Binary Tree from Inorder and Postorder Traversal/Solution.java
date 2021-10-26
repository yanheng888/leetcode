import java.util.HashMap;

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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0){
            return null;
        }
        map.clear();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return dfs(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] postorder, int a, int b, int[] inorder, int m, int n) {
        if(a > b){
            return null;
        }
        TreeNode root = new TreeNode(postorder[b]);
        int pos = map.get(postorder[b]);
        root.left = dfs(postorder, a, a + pos - m - 1, inorder, m, pos - 1);
        root.right = dfs(postorder, a+pos-m, b-1, inorder, pos+1, n);
        return root;
    }
}
