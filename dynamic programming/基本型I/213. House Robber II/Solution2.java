class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for(int len=2;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j = i+len-1;
                dp[i][j] = Math.max(nums[i]+(i+2>j ? 0 : dp[i+2][j]),dp[i+1][j]);
            }
        }
        return Math.max(dp[1][n-1],nums[0]+dp[2][n-2]);
    }
}
