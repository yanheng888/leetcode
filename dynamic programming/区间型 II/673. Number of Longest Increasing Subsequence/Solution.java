class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] cnt = new int[n];
        int maxLen = 0;
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            maxLen = 1;
            maxCnt = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    if(maxLen == len[j]+1){
                        maxCnt += cnt[j];
                    }else if(maxLen < len[j]+1){
                        maxLen = len[j]+1;
                        maxCnt = cnt[j];

                    }
                }
            }
            len[i] = maxLen;
            cnt[i] = maxCnt;
        }
        maxLen = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(len[i] == maxLen){
                res += cnt[i];
            }else if(len[i] > maxLen){
                maxLen = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
