class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n < 8){
            for (int num: nums){
                if(num == target){
                    return true;
                }
            }
            return false;
        }
        int low = 0, high = n-1;
        while(low < high && nums[0] == nums[high]){
            high--;
        }
        while (low <= high && nums[low] >= nums[n-1]){
            int mid = low+(high-low)/2;
            if(nums[mid]>=nums[low]){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        if(target == nums[n-1]){
            return true;
        }
        if(target>nums[n-1]){
            if(low >= 1 && low < n && nums[low] < nums[low-1]){
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
                return true;
            }
        }
        return false;
    }
}
