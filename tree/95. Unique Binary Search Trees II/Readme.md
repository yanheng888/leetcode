

通过观察，root.val为1-n, 左子树区间[1,root.val-1],右子树区间[root.val+1,end]. 所以在dfs里需要用到for loop. 既然有区间，dfs出口自然是区间的边界。

出口：

```java
if(start>end){
  res.add(null);
  return res;
}
if(start==end){
  res.add(new TreeNode(start));
  return res;
}
```

用for loop 遍历 start-end所有可能的根

```
for(int i = start; i <= end; i++){
}
```

然后用DFS 中序遍历得到所有可能的left tree, right tree
```
List<TreeNode> leftTree = dfs(start, i - 1);
List<TreeNode> rightTree = dfs(i + 1, end);
```

然后以当前根为root,暴力得出所有left tree + root + right tree组合
```java
for(TreeNode lNode: leftTree){
    for(TreeNode rNode: rightTree){
        TreeNode root = new TreeNode(i);
        root.left = lNode;
        root.right = rNode;
        arr.add(root);
    }
}
```
