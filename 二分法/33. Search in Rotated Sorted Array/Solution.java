class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        while (low <= high && nums[low] > nums[high]){
            int mid = low+(high-low)/2;
            if(nums[mid]>=nums[low]){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        if(target == nums[n-1]){
            return n-1;
        }
        if(target>nums[n-1]){
            if(low >= 1 && nums[low] < nums[low-1]){
                low--;
            }
            high = low;
            low = 0;
        }else{
            high = n-1;
        }
        while (low <= high){
            int mid = low+(high-low+1)/2;
            if(nums[mid]<target){
                low = mid+1;
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
