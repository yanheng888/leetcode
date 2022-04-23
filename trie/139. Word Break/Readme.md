
Solution:dfs+Trie
注意点：
- 构建trie.trie的第一个节点可能包含多个word的首字母，如wordDict=['go','special'],则next= [null,...,'g',...'s']
- 因为next第一节点可能包含多个首字母，所以dfs(root,..),传进去的参数应该是跟节点
- 记忆化应该用int[],而不是hashmap,因为是根据cur,当前遍历的下标来记录状态，而不是字符串。
- int[]的长度为s.length,而不是26

Solution2:dfs+Hashmap(暴力解法）


参考链接：https://www.youtube.com/watch?v=eYT-hKQ1au4
