class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i+len-1 <= n; i++) {
                int j = i+len-1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k-1]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j+1]);
                }
            }
        }
        return dp[1][n];
    }
}
