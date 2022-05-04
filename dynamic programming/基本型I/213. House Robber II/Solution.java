class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        if(n == 3){
            return Math.max(nums[2],Math.max(nums[0],nums[1]));
        }
        int p=0,q=0,res=0;
        for (int i = 1; i < n; i++) {
            int p_pre = p;
            int q_pre = q;
            p = nums[i]+q_pre;
            q = Math.max(p_pre,q_pre);
        }
        res = Math.max(p,q);
        p=nums[0];
        q=nums[0];
        for (int i = 2; i < n-1; i++) {
            int p_pre = p;
            int q_pre = q;
            p = nums[i]+q_pre;
            q = Math.max(p_pre,q_pre);
        }
        res = Math.max(res,p);
        res = Math.max(res,q);
        return res;
    }
}
