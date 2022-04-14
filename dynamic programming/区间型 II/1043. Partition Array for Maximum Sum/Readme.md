
dp[i]:the largest sum of the given array after partitioning for dp[0,i]

因为区间大小 <= k, => 区间大小可以为1，2，3，。。。，k. 所以遍历数组时候，对于每个i,还需要往左推k-1位,可能的情况有：{i},{i-1},...{i-k+1},需求出所以情况的最大值


参考链接：https://www.youtube.com/watch?v=Zd00uagpi4U
