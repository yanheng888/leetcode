class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp[0] = nums[0];
        dp2[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(Math.max(dp[i-1]*nums[i], nums[i]),dp2[i-1]*nums[i]);
            dp2[i] = Math.min(Math.min(dp[i-1]*nums[i], nums[i]),dp2[i-1]*nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
