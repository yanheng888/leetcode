class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];

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
