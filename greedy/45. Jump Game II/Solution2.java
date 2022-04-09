class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int position = nums.length-1;
        while (position > 0){
            for (int i = 0; i <= position; i++) {
                if(nums[i]+i >= position){
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
