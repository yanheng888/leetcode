import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int preSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num:nums){
            preSum += num;
            if(map.containsKey(preSum-k)){
                res += map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);

        }
        return res;
    }
}
