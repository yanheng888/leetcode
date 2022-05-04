class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int[] gain = new int[10001];
        for(int num:nums){
            gain[num] += num;
        }
        int p=0,q=0;
        for (int i = 1; i <= 10000; i++) {
            int p_pre = p;
            int q_pre = q;
            p = gain[i]+q_pre;
            q = Math.max(p_pre,q_pre);
        }
        return Math.max(p,q);
    }
}
