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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        map.clear();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int a, int b, int[] inorder, int m, int n) {
        if(a > b){
            return null;
        }
        TreeNode root = new TreeNode(preorder[a]);
        int pos = map.get(preorder[a]);
        root.left = dfs(preorder, a+1, a + pos - m, inorder, m, pos - 1);
        root.right = dfs(preorder, a+pos-m+1, b, inorder, pos+1, n);
        return root;
    }
}
