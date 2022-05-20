设 f[i]f[i] 表示字符串的前缀 s[0..i]s[0..i] 的最少分割次数。要想得出 f[i]f[i] 的值，我们可以考虑枚举 s[0..i]s[0..i] 分割出的最后一个回文串，这样我们就可以写出状态转移方程：

f[i] = min(f[j])+1, 0<=j<i 其中 s[j+1..i] 是一个回文串


即我们枚举最后一个回文串的起始位置 j+1j+1，保证 s[j+1..i]s[j+1..i] 是一个回文串，那么 f[i]f[i] 就可以从 f[j]f[j] 转移而来，附加 11 次额外的分割次数。

注意到上面的状态转移方程中，我们还少考虑了一种情况，即 s[0..i]s[0..i] 本身就是一个回文串。此时其不需要进行任何分割，即：

https://leetcode-cn.com/problems/palindrome-partitioning-ii/solution/fen-ge-hui-wen-chuan-ii-by-leetcode-solu-norx/

