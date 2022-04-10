class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        int n = arr.length;
        for (int i = n/2-1; i >= 0; i--) {
            heapify(arr,i,n-1);
        }
        for (int i = 0; i < k; i++) {
            heapify(arr,0,n-1-i);
            myswap(arr,0,n-1-i);
            res[i] = arr[n-1-i];
        }
        return res;
    }

    private void heapify(int[] arr,int i,int high) {
        int left = 2*i+1;
        int right = 2*i+2;
        int minn_idx = i;
        if(left <= high){
            minn_idx = arr[i] < arr[left] ? i : left;
        }
        if(right <= high){
            minn_idx = arr[minn_idx] < arr[right] ? minn_idx : right;
        }
        if(minn_idx != i){
            myswap(arr,minn_idx,i);
            heapify(arr,minn_idx,high);
        }
    }

    private void myswap(int[] arr, int minn_idx, int i) {
        int temp = arr[minn_idx];
        arr[minn_idx] = arr[i];
        arr[i] = temp;
    }
}
