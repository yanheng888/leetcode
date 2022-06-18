**85.Inorder-Successor-in-BST**
很明显，**基本思想就是对二叉树进行中序遍历，遍历到p后，输出它的下一个遍历对象**。

因此，需要设置一个全局变量 TreeNode* last 来存储最近读到的节点。在遍历的过程中，如果发现last==p，则当前读取的节点就是想要的东西；否则更新last为当前读取的节点。

我们首选比较清晰的递归法来遍历。注意，根据题目要求，这次我们需要给DFS设置一个返回值。初步的框架如下：


```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode last = null;
    TreeNode res = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        inorderSuccessor(root.left,p);
        if(res == null && last == p){//res 只能被修改一次
            res = root;
            return root;
        }
        last = root;
        inorderSuccessor(root.right,p);
        return res;
    }
}
```



Notice:

- Res 只能被修改一次，一旦不为null，不再修改
