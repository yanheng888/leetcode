用hashmap 记录当前level子节点最左节点,然后和当前root的子节点连接起来，然后更新map

dfs postorder 确保可以得到当前节点的左右子节点，然后连接他们

观察题目可知，需要：

1. 连接当前root的左右节点
2. 连接同一level的上一个节点

由观察可知，postorder最合适。要做到2，则需要知道当前level上一个访问的节点的右节点，因为需要将该节点和当前节点的左节点相连接. 显然HashMap适合用来解决这个问题。需要注意的是

```
dfs(root.left,lev+1);
dfs(root.right,lev+1);
Node node = map.get(lev);
map.put(lev,root.right);
```

Level是当前访问的lev,这时ma p得到的是当前level上一个访问的节点的右节点。
