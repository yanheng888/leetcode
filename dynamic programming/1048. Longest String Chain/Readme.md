Notice:
- check() return true if j == n. If shorter word pointer reach end, return true
- words按照字符串长度排序
- check函数用于判断是否子序列
- 状态定义：以words[i]为结尾的最长子序列长度
- 状态转移：遍历j=1..i-1之间： dp[i] = max(dp[i],dp[j]+1)



reference:https://leetcode-cn.com/problems/longest-string-chain/solution/python3-dong-tai-gui-hua-by-caiji-ud-w8yu/
