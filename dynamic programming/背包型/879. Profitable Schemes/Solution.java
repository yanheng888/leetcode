import java.util.Arrays;

class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n+1][minProfit+1];
        int M = 1000000007;
        dp[0][0] = 1;
        for (int i = 0; i < group.length; i++) {
            int x = group[i];
            int y = profit[i];

            for (int j = n; j >= x; j--) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[j][k] += dp[j-x][Math.max(0,k-y)];
                    dp[j][k] %= M;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n+1; i++) {
            res += dp[i][minProfit];
            res %= M;
        }
        return res;
    }
}
