import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class Solution {
    int K;
    Random random = new Random();
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

    private int randomPartition(int[] nums,int left, int right){
        int rand = random.nextInt(right-left+1)+left;
        swapp(nums,rand,right);
        return partition(nums, left, right);
    }
    private void quickSort(int[] nums, int left, int right) {
        if(left > right){
            return;
        }
        int pivot = randomPartition(nums, left, right);
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
