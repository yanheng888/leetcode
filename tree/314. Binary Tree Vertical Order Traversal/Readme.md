使用bfs遍历树。以当前root为对照坐标，offset=1,left node: offset--; right node:offset++.并用Map记录所有offset-》对应的list
```
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
