Solution1:BFS

使用bfs遍历树。以当前root为对照坐标，offset=1,left node: offset--; right node:offset++.并用Map记录所有offset对应的list

```java
while(!q1.isEmpty()){
    TreeNode node = q1.poll();
    Integer offset = q2.poll();
    ArrayList<Integer> lst = map.getOrDefault(offset, new ArrayList<>());
    lst.add(node.val);
    if(node.left != null){
        q1.add(node.left);
        q2.add(offset-1);
    }
    if(node.right != null){
        q1.add(node.right);
        q2.add(offset+1);
    }
    map.put(offset,lst);
}
```

参考链接：https://www.youtube.com/watch?v=Q8Vf_iIMy1w



Solution2:DFS

通过观察可以知道vertical order和节点的[x,y]坐标有关，则当dfs需要添加两个参数,[x,y]来记录当前遍历节点的坐标。通过Treemap 可以保证，res的x排序是正确的.如果同一x坐标的有多个节点，则需要根据他们的Y坐标排序。

所以需要试用int[] pair来记录[y,root.val]，这样方便之后排序. 对于每一个x坐标，根据他们的Y坐标排序，则可以保证是vertical order
