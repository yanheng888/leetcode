class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int first = s.charAt(i-1) - '0';
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first != 0){
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}

//12,226
