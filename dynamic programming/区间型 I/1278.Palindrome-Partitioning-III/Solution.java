import java.util.Arrays;

class Solution {
    public int palindromePartition(String s, int K) {
        int n = s.length();
        s = "#"+s;
        int[][] dp = new int[n+1][K+1];
        int[][] f = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
//            Arrays.fill(f[i],Integer.MAX_VALUE/2);
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
            f[i][i] = 0;
        }
        dp[0][0] = 0;
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)){
                    f[i][j] = f[i+1][j-1];
                }else{
                    f[i][j] = f[i+1][j-1]+1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= Math.min(i,K); k++) {
                for (int j = k; j <= i; j++) {
                    dp[i][k] = Math.min(dp[i][k], dp[j-1][k-1]+f[j][i]);
                }
            }
        }
        return dp[n][K];
    }


}
