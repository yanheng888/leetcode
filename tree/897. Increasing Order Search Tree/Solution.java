
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
    TreeNode pre = null, head = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        increasingBST(root.left);
        if(pre != null){
            root.left = null;
            pre.right = root;
            pre = root;
        }
        if(head == null){
            head = root;
            pre = root;
        }
        increasingBST(root.right);
        return head;
    }

   
}
