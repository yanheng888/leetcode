import java.util.ArrayList;
import java.util.HashMap;
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
    List<TreeNode> res;
    HashMap<String,Integer> map;
    HashMap<String,Integer> stringToUid;
    int t;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        map = new HashMap<>();
        stringToUid = new HashMap<>();
        t = 0;
        collect(root);
        return res;
    }

    private Integer collect(TreeNode root) {
        if(root == null){
            return 0;
        }
        String serial = String.join(",",root.val+"",collect(root.left)+"",collect(root.right)+"");
        stringToUid.computeIfAbsent(serial,key->++t);
        map.put(serial,map.getOrDefault(serial,0)+1);
        if(map.get(serial) == 2){
            res.add(root);
        }
        return stringToUid.get(serial);
    }
}
