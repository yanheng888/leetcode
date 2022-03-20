https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode-solution-o0cp/


本题首先要做转化，这是因为target可能负数，这样dp[i][target]就非法了。讲求target转化成求neg, neg 定义是从nums中选取 若干数，这些数前加上 “-”， 这些数字之和为neg，这里的和指的是不加任何符号的和。 先求出nums 所有数的和，则需要加“+”的和为 sum - neg. 然后将neg 和 sum-neg拼接起来。 (sum-neg)-neg = sum-2*neg=target. 这里neg前为“-”是因为拼接在一起了，被选中作为neg集合里的数都要乘以-1。

可以推导出， neg = (sum-target)/2. 则此时 dp[i][neg] 等同于 dp[i][target].

在遍历时，我们可以选择加或者不加 num, 是因为我们已经定义neg,是从nums中选取 若干数,所以我们可以选这个数，也可以不选这个数
```
dp[i][j] = dp[i-1][j];
if(j >= x){
    dp[i][j] += dp[i-1][j-x];
}
```

还需要注意的是 dp[i][j]表示，前i个数sum = j 的个数，所以第一层循环需要从1到n, x= nums[i-1]
```
for (int i = 1; i <= n; i++) {
    int x = nums[i-1];
```
