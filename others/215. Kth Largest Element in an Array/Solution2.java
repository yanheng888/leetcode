class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        heapSort(nums);
        return nums[n-k+1-1];
    }

    private void heapSort(int[] nums) {
        int n = nums.length;
        for (int j = n/2-1; j >= 0; j--) {
            heapify(nums,n,j);
        }
        for (int j = n-1; j > 0; j--) {
            swapp(nums,j,0);
            heapify(nums,j,0);
        }
    }

    private void swapp(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < n && nums[largest] < nums[left]){
            largest = left;
        }
        if(right < n && nums[largest] < nums[right]){
            largest = right;
        }
        if(largest != i){
            swapp(nums,largest,i);
            heapify(nums,n,largest);
        }
    }

}
