class Solution {
    public String longestPrefix(String s) {
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
        int len = dp[n-1];
        return s.substring(0,len);
    }
}
