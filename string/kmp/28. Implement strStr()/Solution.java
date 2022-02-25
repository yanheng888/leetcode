class Solution {
    public int strStr(String s, String p) {
        int n = s.length();
        int m = p.length();
        if(m == 0){
            return 0;
        }
        if(n == 0){
            return -1;
        }
        int[] suf = preProcess(p);
        int[] dp = new int[s.length()+1];
        dp[0] = s.charAt(0) == p.charAt(0) ? 1 : 0;
        if(dp[0] == 1 && m == 1){
            return 0;
        }
        for (int i = 1; i < n; i++) {
            int j = dp[i-1];
            while (j >= 1 && s.charAt(i) != p.charAt(j)){
                j = suf[j-1];
            }
            if(s.charAt(i) == p.charAt(j)){
                dp[i] = j + 1;
            }
            if(dp[i] == m){
                return i - m + 1;
            }
        }
        return -1;
    }

    public int[] preProcess(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = 1; i < n; i++) {
            int j = dp[i-1];
            while (j >= 1 && s.charAt(i) != s.charAt(j)){
                j = dp[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                dp[i] = j+1;
            }
        }
        return dp;
    }
}
