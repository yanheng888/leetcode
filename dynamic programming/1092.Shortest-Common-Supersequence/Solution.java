class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        str1 = "#"+str1;
        str2 = "#"+str2;
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        int i = m, j = n;
        StringBuilder ret = new StringBuilder();
        while (i > 0 && j > 0){
            if(str1.charAt(i) == str2.charAt(j)){
                ret.append(str1.charAt(i));
                --i;
                --j;
            }else if(dp[i][j] == dp[i][j-1]+1){
                ret.append(str2.charAt(j));
                --j;
            }else{
                ret.append(str1.charAt(i));
                --i;
            }
        }
        while(i>0){
            ret.append(str1.charAt(i));
            --i;
        }
        while(j>0){
            ret.append(str2.charAt(j));
            --j;
        }
        return ret.reverse().toString();
    }
}
