import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n < 3){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++) {//[-1,0,1,2,-1,-4]
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int low = i+1, high = n-1;
            while (low < high){
                if(nums[low] + nums[high] == target){
                    res.add(Arrays.asList(-target,nums[high],nums[low]));
                    while (low+1 < high && nums[low] == nums[low+1]){
                        low++;
                    }
                    while (high-1 > low && nums[high] == nums[high-1]){
                        high--;
                    }
                    low++;
                    high--;
                }else if(nums[low] + nums[high] < target){
                    low++;
                }else{
                    high--;
                }
            }
        }
        return res;
    }
}
