
dfs+for loop 表示 dfs尝试一段字符串number[index,i]是否可行，如果可行则进入下一层，如果每一层都可行，则返回true

Notice:

- 使用dfs(...,i+1,...),穿进去的参数是i+1不是index+1
- 能使用long就不使用int,因为可能出现overflow
- 只有当index>=num.length()可能返回true,取决于cnt>2

reference:https://leetcode-cn.com/problems/additive-number/solution/tong-ge-lai-shua-ti-la-dfs-jian-zhi-by-t-jxsf/
