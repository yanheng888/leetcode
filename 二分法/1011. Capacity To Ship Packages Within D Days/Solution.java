class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            int w = weights[i];
            high += w;
        }
        while (low < high){
            int mid = low+(high-low)/2;
            if(isOk(mid,weights,days)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private boolean isOk(int mid, int[] weights,int days) {
        int n = weights.length;
        for (int i = 0; i < n;) {
            int j = i;
            int sum = 0;
            while (j < n && sum+weights[j] <= mid){
                sum += weights[j++];
            }
            days--;
            if(days < 0){
                return false;
            }
            i = j;
        }
        return true;
    }
}
