BST的性质就是进行先序遍历的话，必然是第一个递增序列。

用DFS的方法，进行先序遍历。while loop 每次 把当前所有的left node 放入栈中，然后对比left child 和 parent值大小，每次更新left child
