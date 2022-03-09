class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
//        int mid = n/2;
        mergeSort(nums,0,n-1);
        return nums[n-k+1-1];
    }

    private void mergeSort(int[] nums, int low, int high) {
        if(low >= high){
            return;
        }
        int mid = low + (high-low)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int n1 = mid-low+1;
        int n2 = high-mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = low; i <= mid; i++) {
            left[i-low] = nums[i];
        }
        for (int i = mid+1; i <= high; i++) {
            right[i-mid-1] = nums[i];
        }
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2){
            if(left[i] < right[j]){
                nums[k++] = left[i++];
            }else{
                nums[k++] = right[j++];
            }
        }
        while (i < n1){
            nums[k++] = left[i++];
        }
        while (i < n2){
            nums[k++] = right[j++];
        }
    }
}
