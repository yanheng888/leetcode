import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                minn = Math.min(dp[i-j*j],minn);
            }
            dp[i] = minn+1;
        }
        return  dp[n];
    }
}

//return the least number of perfect square numbers that sum to n
