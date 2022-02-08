class Solution {
    public int minInsertions(String s) {
        int m = s.length();
        int[][] dp = new int[m][m];
        for (int i = 0; i < m-1; i++) {
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1) ? 0 : 1);
        }
        for (int len = 3; len <= m; len++) {
            for (int i = 0; i+len-1 < m; i++) {
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1],dp[i+1][j])+1;
                }
            }
        }
        return dp[0][m-1];
    }
}
