import java.util.LinkedList;

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
    int pre = 0;
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode node = q.poll();
                if(node.val - pre != 1){
                    return false;
                }
                pre = node.val;
                if(node.left != null){
                    node.left.val = node.val * 2;
                    q.add(node.left);
                }
                if(node.right != null){
                    node.right.val = node.val * 2 + 1;
                    q.add(node.right);
                }
            }
        }
        return true;
    }

}
