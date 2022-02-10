import java.util.Arrays;

class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sums = new int[n+1];
        int[][] f = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i]+nums[i];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i,m); j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j-1], sums[i] - sums[k]));
                }
            }
        }

        return f[n][m];
    }
}
