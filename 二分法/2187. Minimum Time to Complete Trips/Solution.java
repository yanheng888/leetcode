class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int minT = Integer.MAX_VALUE;
        for(int t:time){
            minT = Math.min(t,minT);
        }
        long l = minT;
        long r = (totalTrips*1L)*minT;
        while (l < r){
            long m = l+(r-l)/2;
            if(!check(m,totalTrips,time)){
                l = m+1;
            }else{
                r = m;
            }
        }
        return r;
    }

    private boolean check(long m,long totalTrips,int[] time) {
        long cnt = 0;
        for(int t:time){
            cnt += m/t;
        }
        return cnt>=totalTrips;
    }
}
