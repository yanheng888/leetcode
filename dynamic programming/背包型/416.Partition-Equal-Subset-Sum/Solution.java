class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int x = 0;
        for (int i = 0; i < n; i++) {
            x += nums[i];
        }
        boolean[] dp = new boolean[x+1];
        if(x%2 != 0){
            return false;
        }
        x /= 2;
        dp[0] = true;
        for (int num:nums) {
            for (int i = x; i >= 0; i--) {
                if(i < num){
                    continue;
                }
                
                if(dp[i-num]){
                    dp[i] = true;
                    if(i == x){
                        return true;
                    }
                }
            }
        }
        return dp[x];
    }
}
