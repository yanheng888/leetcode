class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int maxLen = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            maxLen = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && maxLen < len[j]+1){
                    maxLen = len[j]+1;
                }
            }
            len[i] = maxLen;
            res = Math.max(res,maxLen);
        }
        return res;
    }
}
