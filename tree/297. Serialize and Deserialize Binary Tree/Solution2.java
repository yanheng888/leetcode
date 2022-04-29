import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("#,");
            }else {
                res.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        ArrayList<TreeNode> nodes = new ArrayList<>();
        for(String s: arr){
            if(s.equals("#")){
                nodes.add(null);
            }else{
                nodes.add(new TreeNode(Integer.parseInt(s)));
            }
        }
        int i=0,j=1;
        while (i < nodes.size() && j < nodes.size()){
            if(nodes.get(i) != null){
                nodes.get(i).left = nodes.get(j);
                nodes.get(i).right = nodes.get(j+1);
                j += 2;
            }
            i++;
        }
        return nodes.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
