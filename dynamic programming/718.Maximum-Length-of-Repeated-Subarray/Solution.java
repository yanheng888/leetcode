class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr1 = new int[m+1];
        int[] arr2 = new int[n+1];
        for (int i = 1; i <= m; i++) {
            arr1[i] = nums1[i-1];
        }
        for (int i = 1; i <= n; i++) {
            arr2[i] = nums2[i-1];
        }
        int[][] dp = new int[m+1][n+1];

        int res = 0;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(arr1[i] == arr2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = 0;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
