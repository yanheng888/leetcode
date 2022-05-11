class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0, n = stones.length;
        for (int stone: stones){
            sum += stone;
        }
        boolean[][] dp = new boolean[n+1][sum+1];
        int neg = sum/2;
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            int stone = stones[i];
            for (int j = 0; j <= neg; j++) {
                dp[i+1][j] = dp[i][j];
                if(j >= stone){
                    dp[i+1][j] |= dp[i][j-stone];
                }
            }
        }

        for (int j = neg; ; j--) {
            if(dp[n][j]){
                return sum-2*j;
            }
        }
    }
}
