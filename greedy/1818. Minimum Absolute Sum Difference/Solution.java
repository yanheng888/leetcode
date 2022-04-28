import java.util.Arrays;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        final int MOD = 1000000007;
        int[] arr = Arrays.copyOf(nums1, n);
        Arrays.sort(arr);
        int maxDiff = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int originDiff = Math.abs(nums1[i]-nums2[i]);
            sum = (sum+originDiff)%MOD;
            int j = bs(arr,nums2[i]);
            int diff = Integer.MAX_VALUE;
            if(j < n){
                diff = Math.min(diff,Math.abs(arr[j]-nums2[i]));
            }
            if(j > 0){
                diff = Math.min(diff,Math.abs(arr[j-1]-nums2[i]));
            }
            maxDiff = Math.max(maxDiff,originDiff-diff);
        }
        return (sum-maxDiff+MOD)%MOD;
    }

    private int bs(int[] nums1, int target) {
        int l=0,r=nums1.length-1;
        while (l < r){
            int mid = l+(r-l)/2;
            if(nums1[mid] < target){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return r;
    }
}
