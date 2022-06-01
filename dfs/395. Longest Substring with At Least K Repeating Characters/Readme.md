

本题要求最长substring的长度，该substring 里的每一个元素的频率大于等于K。所以如果一旦包含一个频率小于等于K的元素，则该元素就是“害群之马”，让整个substring不符合要求。



可以将每一个“害群之马”元素当成spliter,将元素分开，然后再用dfs求出最大长度的substring.



Notice:

- 在求最长substring时，需要使用递归不能直接计算.这是因为我们要求的substring的每一个元素的长度大于等于K.如果直接计算re s = Math.max(res,j-i), 这样计算的前提是每一个s.substring(i,j)的每一个元素都大于等于K,显然有时候不符合
- 递归的出口是s中每一个元素频率都大于等于k

reference:
https://www.youtube.com/watch?v=_MJKUvM-4fM

https://github.com/wisdompeak/LeetCode/tree/master/Recursion/395.Longest-Substring-with-At-Least-K-Repeating-Characters
