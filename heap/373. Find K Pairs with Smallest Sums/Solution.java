import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length,n = nums2.length;
        long l = nums1[0]+nums2[0];
        long r = nums1[m-1]+nums2[n-1];
        while (l < r){
            long mid = l+(r-l)/2;
            long x = countLessEqual(mid,nums1,nums2);
            if(countLessEqual(mid,nums1,nums2) < k){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        List<List<Integer>> res1 = new ArrayList<>();
        List<List<Integer>> res2 = new ArrayList<>();
        for(int i=0;i<m;i++){
            int j = 0;
            while (j<n && nums1[i]+nums2[j]<=l && res1.size()<k){
                ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(nums1[i],nums2[j]));
                if(nums1[i]+nums2[j] == l){
                    res2.add(temp);
                }else{
                    res1.add(temp);
                }
                j++;
            }
        }
        int t = Math.min(res2.size(),k-res1.size());
        for (int i = 0; i < t; i++) {
            res1.add(res2.get(i));
        }
        return res1;
    }

    private long countLessEqual(long m, int[] nums1, int[] nums2) {
        int j = nums2.length-1;
        long ret = 0;
        for (int i=0; i<nums1.length; i++)
        {
            while (j>=0 && nums1[i]+nums2[j]>m){
                j--;
            }
            ret += j+1;
        }
        return ret;
    }
}
