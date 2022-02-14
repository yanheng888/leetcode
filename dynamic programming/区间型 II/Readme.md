模版
```
class Solution {
    public int func(int n) {
        int[][] dp = new int[n+1][n+1];

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i+len-1 <= n; i++) {
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j],k + Math.max(dp[i][k-1], dp[k+1][j]));
                }
            }
        }
        return dp[1][n];
    }
}
```

通常需要找dp[i][j]与dp[i+1][j-1],dp[i][j-1],dp[i+1][j] 之间的关系。
```
a b
c d
```
假设b坐标为dp[i][j],则c,a,d分别为dp[i+1][j-1],dp[i][j-1],dp[i+1][j]。当计算dp[i][j]时候,a,c,d的值已经计算出来。所以dp[i][j]必然与这三位置有关。
