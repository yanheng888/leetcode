因为是bst，所以比236更简单，并且235答案同样适用此题。

一共有三种情况，pq 全在 root 左边，则向左搜索。pq 全在 root 右边，则向右搜索。pq在root两边，则返回root,因为根据bst，此时pq一个比root大，一个比root小（在root左右两边）。可以推出pq向上递归，会在root会和，root为lca

```
if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
```
