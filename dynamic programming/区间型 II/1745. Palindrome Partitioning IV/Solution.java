class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        s = "#"+s;
        boolean[][] dp = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 1; len+i-1 <= n; i++) {
                int j = len+i-1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = false;
                }
            }
        }

        for (int i = 1; i <= n-2; i++) {
            for (int j = i+1; j <= n-1; j++) {
                if(dp[1][i] && dp[i+1][j] && dp[j+1][n]){
                    return true;
                }
            }
        }
        return false;
    }
}
