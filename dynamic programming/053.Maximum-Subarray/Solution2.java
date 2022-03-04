class Solution {
    public int maxSubArray(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int subSum = 0;
        int res = nums[0];
        while (j < n){
            subSum += nums[j];
            while ((subSum < 0 || nums[i] < 0) && i < j){
                subSum -= nums[i++];
            }
            res = Math.max(subSum,res);
            j++;
        }
        return res;
    }
}
