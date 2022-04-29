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
    String[] arr;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        StringBuilder res = new StringBuilder();
        res.append(root.val).append(",").append(serialize(root.left)).append(",").append(serialize(root.right));
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        arr = data.split(",");
        if(arr.length == 0){
            return null;
        }

        return dfs(null,0);
    }

    private TreeNode dfs(TreeNode root,int k) {
        if(arr[k].equals("#")){
            return null;
        }
        root = new TreeNode(Integer.parseInt(arr[k]));
        root.left = dfs(root,k+1);
        int n = getNodeNums(root.left);
        root.right = dfs(root,k+1+n);
        return root;
    }

    private int getNodeNums(TreeNode root) {
        if(root == null){
            return 1;
        }
        return 1+getNodeNums(root.left)+getNodeNums(root.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
