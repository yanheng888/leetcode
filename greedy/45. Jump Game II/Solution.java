class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        int cnt = 0;
        while (i < n){
            int idx = i;
            int maxx = Integer.MIN_VALUE;
            if(i+nums[i] >= n-1){
                return cnt+1;
            }
            for (int j = i+1; j <= i+nums[i]; j++) {
                if(maxx <= nums[j]+j){
                    maxx = nums[j]+j;
                    idx = j;
                }
            }
            cnt++;
            i = idx;
        }
        return cnt;
    }
}
