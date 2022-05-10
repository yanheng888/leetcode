import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;

        for (int i = 1; i < amount+1; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int x = i - coins[j];
                if(i-coins[j] >= 0 && dp[i-coins[j]] != -1){
                    temp = Math.min(temp,dp[i-coins[j]]+1);
                }
            }
            if(temp == Integer.MAX_VALUE){
                dp[i] = -1;
            }else{
                dp[i] = temp;
            }
        }
        return dp[amount];
    }
}

//1,2,5
