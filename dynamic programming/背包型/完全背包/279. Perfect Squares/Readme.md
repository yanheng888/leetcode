注意优化：

可以将dp[i] = Math.min(dp[i],dp[i-c]) 优化成

```
int minn = Integer.MAX_VALUE;
for (int j = 1; j*j <= i; j++) {
    minn = Math.min(dp[i-j*j],minn);
}
```

这样，不用对数组修改，直接修改minn,速度快很多。而且此处for循环为j*j <= i,这样减少了循环的次数


https://leetcode-cn.com/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode-solut-t99c/
