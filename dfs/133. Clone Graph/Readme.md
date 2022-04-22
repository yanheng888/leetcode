
Solution: dfs+hashmap
- 这里只能用Hashmap不能用queque.因为hashmap可以根据当前访问的节点返回存储的newNode, 而queue则不行

- map(oldNode,newNode) map key is old node since we are traversing oldNode and its neighbors
