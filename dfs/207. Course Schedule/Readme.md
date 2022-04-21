
Solution: dfs
- visited[i] = 1, 曾经的访问过的任意一个路径访问过这个点
- visited[i] = 2, 目前正在访问过的路径访问过这一点
- 当当前节点回到了目前路径访问过的节点时，说明有一个环,return false；当当当前节点被非当前路径的其他路径访问过时，说明这个点没有环,return true

Solution2: bfs

计算indegree,每个节点有多少个数指向这个节点，如果indegree[i] = 0, 则加入queue

参考链接：https://www.youtube.com/watch?v=5fntVoXeW_A
