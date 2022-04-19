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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(root);
        q2.add(0);
        while(!q1.isEmpty()){
            TreeNode node = q1.poll();
            Integer offset = q2.poll();
            ArrayList<Integer> lst = map.getOrDefault(offset, new ArrayList<>());
            lst.add(node.val);
            if(node.left != null){
                q1.add(node.left);
                q2.add(offset-1);
            }
            if(node.right != null){
                q1.add(node.right);
                q2.add(offset+1);
            }
            map.put(offset,lst);
        }
        for(Integer key:map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}
