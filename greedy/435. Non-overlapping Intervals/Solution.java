import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int r = intervals[0][1];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if(r <= intervals[i][0]){
                cnt++;
                r = intervals[i][1];

            }
        }
        return n - cnt;
    }
}
