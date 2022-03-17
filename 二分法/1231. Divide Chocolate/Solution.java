class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int n = sweetness.length;
        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            high += sweetness[i];
        }
        while (low < high){
            int mid = low+(high-low+1)/2;
            if(isOk(mid,sweetness,k)){
                low = mid;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private boolean isOk(int mid, int[] sweetness,int k) {
        int n = sweetness.length;
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sweetness[i];
            if(sum >= mid){
                sum = 0;
                cnt++;
            }
        }
        return cnt >= k+1;
    }
}
