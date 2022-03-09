import java.util.Arrays;
import java.util.Collections;

class Solution {
    int K;
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        this.K = n-k+1;
        if(k > n){
            return -1;
        }
        quickSort(nums,0,n-1);
        return nums[n-k];
    }

    private int partition(int[] nums,int left, int right) {
        int n = nums.length;
        int pivot = nums[right];
        int i = left-1;
        for (int j = left; j < right; j++) {
            if(nums[j] < pivot){
                i++;
                swapp(nums,i,j);
            }
        }
        i++;
        swapp(nums,i,right);
        return i;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left > right){
            return;
        }
        int pivot = partition(nums, left, right);
        if(pivot+1 < K){
            quickSort(nums,pivot+1,right);
        }else if(pivot+1 == K){
            return;
        }else{
            quickSort(nums,left,pivot-1);
        }

    }

    private void swapp(int[] nums, int i, int j) {
        if(i > j){
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
