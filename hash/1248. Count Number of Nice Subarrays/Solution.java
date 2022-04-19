class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int pre = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;
        for(int i=0;i<n;i++){
            pre += nums[i]&1;
            if(pre >= k && map.containsKey(pre-k)){
                res += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return res;
    }
}
