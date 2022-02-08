class Solution {
    public int minimumDeleteSum(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        word1 = "#"+word1;
        word2 = "#"+word2;

        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += word1.charAt(i);
        }
        for (int j = 1; j <= n; j++) {
            res += word2.charAt(j);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + word1.charAt(i);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return res - 2*dp[m][n];
    }
}
