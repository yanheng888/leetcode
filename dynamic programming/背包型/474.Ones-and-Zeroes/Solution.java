class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int c0 = 0, c1 = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0'){
                    c0++;
                }else{
                    c1++;
                }
            }//"10","0001","111001","1","0"
//            for (int i = c0; i <= m; i++) {
//                for (int j = c1; j <= n; j++) {
//                    System.out.println(i+" "+j+" "+(i-c0)+" "+(i-c1));
//                    dp[i][j] = Math.max(dp[i-c0][j-c1]+1,dp[i][j]);
//                }
//            }
            for (int i = m; i >= c0; i--) {
                for (int j = n; j >= c1; j--) {
                    // System.out.println(i+" "+j+" "+(i-c0)+" "+(i-c1));
                    dp[i][j] = Math.max(dp[i-c0][j-c1]+1,dp[i][j]);
                }
            }
            // System.out.println("-------------Round end-------------");
        }

        return dp[m][n];
    }
}
