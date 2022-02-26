class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int res = n-1;
        int i = 1, j = 1;
        while(j < n){
            if(nums[j-1] != nums[j]){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
