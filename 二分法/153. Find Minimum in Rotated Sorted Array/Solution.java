class Solution {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int low = 0, high = n-1;
        if(nums[low] <= nums[high]){
            return nums[low];
        }
        while (low <= high){
            int mid = low+(high-low)/2;
            if(nums[0] <= nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return nums[low];
    }
}
