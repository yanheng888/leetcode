/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    HashMap<Integer,Node> map;
    public Node connect(Node root){
        map = new HashMap();
        dfs(root,0);
        return root;
    }
    public Node dfs(Node root,int lev) {
        if(root == null){
            return null;
        }
        Node left = dfs(root.left,lev+1);
        Node right = dfs(root.right,lev+1);
        Node node = map.get(lev);
        map.put(lev,right);
        if(node != null){
            node.next = left;
        }
        if(left != null){
            left.next = right;
        }
        return root;
    }
}
