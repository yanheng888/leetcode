import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        int diff = (sum-target);
        if(diff < 0 || diff % 2 == 1){
            return 0;
        }
        int neg = diff/2;
        int[][] dp = new int[nums.length+1][neg+1];
        int n = nums.length;
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i-1];
            for (int j = neg; j >= 0; j--) {
                dp[i][j] = dp[i-1][j];
                if(j >= x){
                    dp[i][j] += dp[i-1][j-x];
                }
            }
        }
        return dp[nums.length][neg];
    }
}
