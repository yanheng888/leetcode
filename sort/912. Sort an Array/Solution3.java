import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class Solution {
    Random random;
    public int[] sortArray(int[] nums) {
        this.random = new Random();
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    private void mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return ;
        }
        int mid = left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    private int[] merge(int[] nums, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2 = right-mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArr[i] = nums[i+left];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = nums[i+mid+1];
        }

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length){
            if(leftArr[i] < rightArr[j]){
                nums[k] = leftArr[i++];
            }else{
                nums[k] = rightArr[j++];
            }
            k++;
        }
        while (i < leftArr.length){
            nums[k++] = leftArr[i++];
        }
        while (j < rightArr.length){
            nums[k++] = rightArr[j++];
        }
        return nums;
    }


    private void myswap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
