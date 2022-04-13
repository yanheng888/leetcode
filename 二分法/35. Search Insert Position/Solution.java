class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high){
            int mid = (high-low)/2+low;
            if(nums[mid] > target){
                high = mid-1;
            }else if(nums[mid] == target){
                return mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
