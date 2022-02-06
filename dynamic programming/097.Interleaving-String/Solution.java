class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m+n != s3.length()){
            return false;
        }
        s1 = "#"+s1;
        s2 = "#"+s2;
        s3 = "#"+s3;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = (dp[i - 1][0] && s1.charAt(i) == s3.charAt(i));
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = (dp[0][j-1] && s2.charAt(j) == s3.charAt(j));
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i)== s3.charAt(i+j) && dp[i - 1][j]) {
                    dp[i][j] = true;
                }else if (s2.charAt(j)== s3.charAt(i+j) && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[m][n];
    }
}
