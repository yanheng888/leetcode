class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        int maxx = Integer.MIN_VALUE;
        for (int i = 1; i <= k; i++) {
            maxx = Math.max(maxx,arr[i-1]);
            dp[i-1] = maxx*i;
        }
        for (int i = k; i < n; i++) {
            maxx = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                maxx = Math.max(maxx,arr[i-j]);
                dp[i] = Math.max(dp[i],dp[i-j-1]+maxx*(j+1));
            }
        }
        return dp[n-1];
    }
}
