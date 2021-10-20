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
    public int widthOfBinaryTree(TreeNode root) {
        int ret = 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        root.val = 0;
        que.add(root);
        while(!que.isEmpty()){
            ret = Math.max(ret, que.getLast().val - que.getFirst().val + 1);
            int len = que.size();
            for(int i = 0; i < len; i++){
                TreeNode node = que.poll();
                if(node.left != null){
                    node.left.val = node.val * 2 + 1;
                    que.add(node.left);

                }
                if(node.right != null){
                    node.right.val = node.val * 2 + 2;
                    que.add(node.right);
                }
            }
        }
        return ret;
    }

}
