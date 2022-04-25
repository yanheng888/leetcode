class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n==0){
            return new int[]{-1,-1};
        }
        int l = 0, r = n-1;
        int[] res = new int[2];
        while (l<r){
            int m = l+(r-l)/2;
            if(nums[m] < target){
                l = m+1;
            }else{
                r = m;
            }
        }
        res[0] = nums[r]==target ? r : -1;
        l = r;
        r = n-1;
        while (l<r){
            int m = l+(r-l+1)/2;
            if(nums[m] <= target){
                l = m;
            }else {
                r = m-1;
            }
        }
        res[1] = nums[l]==target ? l : -1;
        return res;
    }
}
