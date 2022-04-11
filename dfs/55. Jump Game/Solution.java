class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        return dfs(nums,0,nums[0]);
    }

    private boolean dfs(int[] nums, int i, int steps) {
        if(i+steps >= nums.length-1){
            return true;
        }
        boolean res = false;

        int x = 0, y = 0;
        int maxx = Integer.MIN_VALUE;
        for (int j = 1; j <= steps; j++) {
            if(maxx < i+j+nums[i+j]){
                maxx = i+j+nums[i+j];
                x = i;
                y = j;
            }
        }
        if(maxx <= i+steps){
            return false;
        }
        return dfs(nums,x+y,nums[x+y]);
    }
}
