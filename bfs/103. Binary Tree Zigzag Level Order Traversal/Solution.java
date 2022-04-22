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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList();
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        que.add(root);
        int level=0;
        List<Integer> temp = new ArrayList();
        temp.add(root.val);
        res.add(temp);
        while(!que.isEmpty()){
            int n = que.size();
            List<Integer> lst = new ArrayList();
            for(int i=0;i<n;i++){
                TreeNode node = que.poll();
                if(node.left != null){
                    que.add(node.left);
                    lst.add(node.left.val);
                }
                if(node.right != null){
                    que.add(node.right);
                    lst.add(node.right.val);
                }
            }
            if(level%2!=1){
                Collections.reverse(lst);
            }
            if(lst.size()!=0){
                res.add(lst);
            }
            level++;
        }
        return res;
    }
}
