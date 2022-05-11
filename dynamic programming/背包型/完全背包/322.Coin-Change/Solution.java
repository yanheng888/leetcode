import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[0] = 0;

        for (int coin:coins) {
            for (int j = 1; j <= amount; j++){
                if(coin>j){
                    continue;
                }
                dp[j] = Math.min(dp[j-coin]+1,dp[j]);
            }
        }
        return dp[amount]>amount ? -1:dp[amount];
    }
}
//the fewest number of coins that you need to make up that amount