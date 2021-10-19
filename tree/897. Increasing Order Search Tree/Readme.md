使用in-order 遍历 tree. 每次递归root.left结束后，
```
if(pre != null){
            root.left = null;
            pre.right = root;
            pre = root;
        }
```
pre总是指向上一次遍历的root,pre.right = root, 将左子树转换成从小到大的直链。

```
if(head == null){
            head = root;
            pre = root;
        }
```
上面代码只会执行一次，是在root最左treeNode执行，这样此treeNode为返回的直链第一个node(因为此treeNode在最左边，最小)
