import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class Solution {
    Random random;
    public int[] sortArray(int[] nums) {
        this.random = new Random();
        myQuickSort(nums,0,nums.length-1);
        return nums;
    }

    private void myQuickSort(int[] nums, int left, int right) {
        if(left > right){
            return;
        }
        int pivIdx = partition(nums,left,right);
        myQuickSort(nums,left,pivIdx-1);
        myQuickSort(nums,pivIdx+1,right);
    }

    private int partition(int[] nums, int left, int right) {
        int i = left-1;
        int j = left;
        int pivotIdx = random.nextInt(right-left+1)+left;
        int pivot = nums[pivotIdx];
        while (j <= right){
            if(nums[j] < pivot){
                i++;
                myswap(nums,i,j);
            }
            j++;
        }
        i++;
        myswap(nums,i,pivotIdx);
        return i;
    }


    private void myswap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
