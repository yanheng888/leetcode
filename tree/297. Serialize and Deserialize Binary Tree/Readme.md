**Solution: dfs preorder**

Notice:
- getNodeNum(TreeNode root) is to get the number of nodes in the subtree whose root is given. If we know the number of num, we can know the interval of left tree and interval of right tree
- in getNodeNums(), if root == null, return 1 since null count "#" in serialization string

**Solution: bfs**

参考链接：https://www.youtube.com/watch?v=6tUBiOYbYgY
