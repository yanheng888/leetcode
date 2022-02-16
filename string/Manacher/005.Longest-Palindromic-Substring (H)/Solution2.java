class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2){
            return s;
        }
        s = "#"+s;
        boolean[][] dp = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        int begin = 1;
        int maxLen = 1;

        for (int len = 2; len <= n; len++) {
            for (int i = 1; len+i-1 <= n; i++) {
                int j = len+i-1;
                if(s.charAt(i) == s.charAt(j)){
                    if(len == 2){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }
                if(dp[i][j] && len >= maxLen){
                    begin = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }
}
