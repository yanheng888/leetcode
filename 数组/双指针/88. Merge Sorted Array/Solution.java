class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        int p = m-1, q = n-1, tail = m + n - 1;
        int cur;
        while(p >= 0 || q >= 0){
            if(p == -1){
                cur = nums2[q--];
            }else if(q == -1){
                cur = nums1[p--];
            }else if(nums1[p] > nums2[q]){
                cur = nums1[p--];
            }else{
                cur = nums2[q--];
            }
            nums1[tail--] = cur;
        }
    }

}
