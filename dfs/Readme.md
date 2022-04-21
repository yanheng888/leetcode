
dfs题型有两类：
- dfs matrix. 对应的题有 200，695，62
- dfs tree. 题目有116，199

dfs matrix:
- 四个方向，上下左右探索，有时需要visited[]来判定之前是否访问过。通常如果之前访问过，则直接返回避免重复访问
```
checkIndex()
visited[i] = true;
dfs(up,down,left,right)
visited[i] = false;
```

dfs tree:
- 通常inorder,postorder,preorder三种看情况用
- 可以在dfs方法中添加一些参数记录当前的状态，如x,y记录相较于root的水平和垂直坐标
- 该类问题有求树的right view, top view, level traverse tree等等
