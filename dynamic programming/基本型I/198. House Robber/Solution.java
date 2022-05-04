class Solution {
    public int rob(int[] nums) {
        int res = 0;
        int p=0,q=0;
        for(int i=0;i<nums.length;i++){
            int p_pre = p;
            int q_pre = q;
            p = nums[i]+q_pre;
            q = Math.max(p_pre,q_pre);
        }
        return Math.max(p,q);
    }
}
