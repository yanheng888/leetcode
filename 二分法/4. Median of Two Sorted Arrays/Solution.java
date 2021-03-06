class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        //nums1's length will always shorter than nums2's length
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0, right = n1;
        while (left <= right){
            int pivx = (left+right)/2;
            //pivy is determined by pivx, pivx decrease cause pivy increase
            int pivy = (n1+n2+1)/2 - pivx;

            //pivx=0 means there is no element in LX
            int maxLX = pivx == 0 ? Integer.MIN_VALUE : nums1[pivx-1];
            int maxLY = pivy == 0 ? Integer.MIN_VALUE : nums2[pivy-1];

            //pivx=n1 means there is no element in RX
            int minRX = pivx == n1 ? Integer.MAX_VALUE : nums1[pivx];
            int minRY = pivy == n2 ? Integer.MAX_VALUE : nums2[pivy];

            if(maxLX <= minRY && maxLY <= minRX){
                if((n1+n2)%2 == 0){
                    return ((Math.max(maxLX,maxLY) + Math.min(minRX,minRY))/2.0);
                }else{
                    return Math.max(maxLX,maxLY)/1.0;
                }
            }else if(maxLX <= minRY){
                left = pivx + 1;
            }else{
                right = pivx - 1;
            }

        }
        return -1;

    }
}
