**解法1：状态压缩DP**

考虑到只有不超过12件jobs，可以用大小不超过4096的01二进制bit来表示任何jobs的组合状态。我们令dp[i][state]表示使用i个工人、分配state所代表的jobs时，可以得到的the minimum possible maximum working time。突破口是第i个工人做了哪些工作？我们可以枚举state的子集subset作为第i个工人的分配任务

思路：题目要求Return the minimum possible maximum working time of any assignment. 看到求最优解,参数又是数组就应该联想到dp。因为有两个变量：jobs,k,这里要是用二维d p数组，其中一维大小为k。另一维比较难想，表示state,大小为(1<<jobs.length).

怎么想到state作为第二维？第一，题目要求maximum working time of any assignment，需要求第i个人的所有分配的工作state。第二，1 <= k <= jobs.length <= 12 暗示可以使用状态压缩

Notice:

1. state^sub 表示xor
2. 一个trick,遍历所有state 的substate

```java
for (int i = 1; i <= k; i++) {
  for (int state = 0; state < (1<<n); state++){
    dp[i][state] = Integer.MAX_VALUE;(3)
    for(int sub=state;sub>0;sub=(sub-1)&state){(2)
      dp[i][state] = Math.min(dp[i][state],Math.max(dp[i-1][state^sub],time[sub]));(1)
    }
  }
}
```

**解法2：二分搜值+状态压缩DFS**

解法1虽然写法简单，但是效率并不高。事实上很多dp[i][state]的状态其实早早对应了某个工人被分配了过长的时间，但是我们没有剪枝，而是暴力把这个二维循环统统计算了出来。

高效的办法就是用二分搜值来假设单个工人的时间上限threshold。然后判断在th的前提下，能否DFS搜索出一个可行解。这里依然可以用状态压缩的DFS。初始状态是(1<<n)-1，每一个回合就减去一个subset（注意这个subset的总时间必须小于等于th）。经过k个回合（分配了k个工人）看看是否能将状态减至0，代表所有的任务都已经安排完毕。

