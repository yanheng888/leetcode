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
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return dfs(inorder,0,postorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode dfs(int[] inorder, int low1, int high1, int[] postorder, int low2, int high2) {
        int n = inorder.length;
        if(n == 0){
            return null;
        }
        if(n == 1){
            return new TreeNode(inorder[0]);
        }
        if(low1 > high1 || low2 > high2){
            return null;
        }
        TreeNode root = new TreeNode(postorder[high2]);
        int rootPosition = map.get(root.val);
        int leftLen = rootPosition-1-low1+1;
        root.left = dfs(inorder,low1,rootPosition-1,postorder,low2,low2+leftLen-1);
        root.right = dfs(inorder,rootPosition+1,high1,postorder,low2+leftLen,high2-1);
        return root;
    }
}
