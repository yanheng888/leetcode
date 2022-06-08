
dfs题型有两类：
- dfs matrix. 对应的题有 200，695，62
- Dfs graph, 207
- dfs tree. 题目有116，199

dfs matrix:
- 四个方向，上下左右探索，有时需要visited[]来判定之前是否访问过。通常如果之前访问过，则直接返回避免重复访问
- 通常要是有hashmap来做memorization(leetcode 62)
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

Dfs graph:

- 用hash map 记录node,edge关系

dfs array:

- 当求所有组合可能性时，可以使用插板法
- 使用插板法时，如果有可能有重复的元素师，可以对比插入的元素和它上一个元素是否值相同，如果相同则不插入，这样可以避免重复(leetcode 47)

Dfs string:





Template:

- Dfs + memorization. 通常使用一维，二维，或者hashmap来记录状态，如果下次访问时候，该状态之前访问过，则直接返回，不用再递归下去

- Visited数组，表示是否访问过。ex:求permutation使用插板法时，尝试每一种可能性时,dfs之前,visited[i]=true,插入当前num至 array,然后dfs(array). dfs结束后,visited[i]=false,array.remove(i).(leetcode 46)

- 当每层dfs需要尝试的可能路径为一个或者大于一个时，需要用到for loop.(leetcode 306,46,47)

- checkIndex(),数组，字符串dfs过程中会涉及到边界，超出边界则直接返回(ex r>n || r < 0)

- ```java
  for (int i = idx; i < candidates.length; i++) 
  {
    int cur = candidates[i];
    if(i > idx && candidates[i]==candidates[i-1])// 避免重复(leetcode 40) 
    {
    	continue;
    }
    ...
   }
  ```

  

Specials:

- Leetcode 638用到了状态压缩
- leetcode 1723用到了二分法
