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
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.getFirst() != null){
            q.add(q.getFirst().left);
            q.add(q.getFirst().right);
            q.poll();
        }

        while(!q.isEmpty()){
            if(q.poll() != null){
                return false;
            }
        }
        return true;

    }
}
