class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;
        if(nums[l] <= nums[r]){
            return nums[0];
        }
        while (l < r && nums[l] > nums[r]){
            int m = l+(r-l+1)/2;
            if(nums[l] <= nums[m]){
                l = m;
            }else{
                r = m-1;
            }
        }
        return nums[l+1];
    }
}
