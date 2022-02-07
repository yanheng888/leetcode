class Solution {
    public boolean isMatch(String s, String p) {
        int M = s.length();
        int N = p.length();
        s = "#"+s;
        p = "#"+p;
        boolean[][] dp = new boolean[M+1][N+1];
        dp[0][0] = true;
        for (int j = 2; j <= N; j++) {
            dp[0][j] = dp[0][j-2] && p.charAt(j) == '*';
        }
        for (int i=1; i<=M; i++){
            for (int j=1; j<=N; j++) {
                if(p.charAt(j)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j)=='*'){
                    boolean temp1 = dp[i][j-2];
                    boolean temp2 = (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') && dp[i-1][j];
                    dp[i][j] = temp1 || temp2;
                }else if(s.charAt(i) == p.charAt(j) && dp[i-1][j-1]){
                    dp[i][j] = true;
                }
            }
        }

        return dp[M][N];
    }
}
