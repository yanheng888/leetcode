使用dfs,先序遍历。如果root.val == p || q, 则返回root. 如果root是lca,则返回root.如果root不是lca, 则向上返回，直到 root.left && root.right != null. 当root.left不为null,意味着left子树有p or q.同理，当两个子树都不为null，则表明root为lca。返回root:

```
if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else if(right != null){
            return right;
        }else{
            return null;
        }
```
