class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int[] gain = new int[10001];
        for(int num:nums){
            gain[num] += num;
        }
        int[] dp = new int[10001];
        dp[1] = gain[1];
        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i-2]+gain[i],dp[i-1]);
        }
        return dp[10000];
    }
}
