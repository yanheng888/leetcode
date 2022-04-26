class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l=0,r=n-1;
        while(l < r && nums[0] == nums[r]){
            r--;
        }
        while (l<r && nums[l] > nums[r]){
            int m = l+(r-l)/2;
            if(nums[m] > nums[r]){
                l = m+1;
            }else{
                r = m;
            }
        }
        if(target == nums[n-1]){
            return true;
        }else if(target > nums[n-1]){
            if(l>=1 && nums[l] < nums[l-1]){
                r = l-1;
            }
            l = 0;
        }else{
            r = n-1;
        }
        while (l<=r){
            int m = l+(r-l)/2;
            if(nums[m] == target){
                return true;
            }else if(nums[m] < target){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return false;
    }
}
