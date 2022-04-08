import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] sortArray(int[] nums) {
        bubbleSort(nums);
        return nums;
    }

    private void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if(nums[j-1] > nums[j]){
                    myswap(nums,j-1,j);
                }
            }
        }
    }

    private void myswap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
