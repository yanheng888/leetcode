import java.util.Arrays;

class Solution {
    int[] time;
    int totalTrips;
    public long minimumTime(int[] time, int totalTrips) {
        this.time = time;
        this.totalTrips = totalTrips;
        long r = Integer.MIN_VALUE;
        for (int t:time){
            r = Math.max(r,t);
        }
        r = r * totalTrips;
        long l = 1;
        while (l < r){
            long m = l + (r-l)/2;
            if(check(m)){
                r = m;
            }else{
                l = m+1;
            }
        }
        return  l;
    }

    private boolean check(long m) {
        long cnt = 0;
        for (int t: time){
            cnt += m/t;
        }
        return cnt >= totalTrips;
    }
}
