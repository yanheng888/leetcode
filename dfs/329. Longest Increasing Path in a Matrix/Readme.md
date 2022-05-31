**Solution: dfs+memorization**

**Solution2: dfs**

我们从任意点A开始递归寻找各条递增路径，最终返回的时候记录从A为起点时的最长路径长度。将此结果记忆化，这样当对其他点进行DFS的时候，如果递归调用到dfs(A)就直接返回结果。

Notice:

- 先用普通dfs解决，然后在此基础上用memorization

Reference:

https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/solution/ju-zhen-zhong-de-zui-chang-di-zeng-lu-jing-by-le-2/
