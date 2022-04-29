import java.util.Arrays;

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        int[] next = new int[n];
        int[] last = new int[n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '*'){
                cnt++;
            }
            preSum[i] = cnt;
        }
        int temp = -1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '|'){
                temp = i;
            }
            last[i] = temp;
        }
        temp = n;
        for (int i = n-1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == '|'){
                temp = i;
            }
            next[i] = temp;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int a = q[0];
            int b = q[1];
            int x = next[a], y = last[b];
            if(x>=a && y<= b && x<=y){
                res[i] = preSum[y]-preSum[x];
            }else{
                res[i] = 0;
            }
        }
        return res;

    }
}
