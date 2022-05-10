class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        int n = coins.length;
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int c = coins[i]; c <= amount; c++) {
                int coin = coins[i];
                dp[c] += dp[c-coin];
            }
        }
        return dp[amount];
    }
}
