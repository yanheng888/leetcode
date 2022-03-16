class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[]{-1,-1};
        if(n == 0){
            return res;
        }
        if(nums[0] == nums[n-1] && nums[0] == target){
            return new int[]{0,n-1};
        }
        int low = 0, high = n-1;
        while (low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                high = mid-1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        if(high+1 < n && nums[high+1] == target){
            res[0] = ++high;
            low = high;
            high = n-1;
            while (low <= high){
                int mid = low+(high-low)/2;
                if(nums[mid] == target){
                    low = mid+1;
                }else if(nums[mid] < target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            res[1] = --low;
        }
        return res;
    }
}
