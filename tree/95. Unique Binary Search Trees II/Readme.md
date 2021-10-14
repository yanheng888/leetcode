

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
```
for(TreeNode lNode: leftTree){
    for(TreeNode rNode: rightTree){
        TreeNode root = new TreeNode(i);
        root.left = lNode;
        root.right = rNode;
        arr.add(root);
    }
}
```
