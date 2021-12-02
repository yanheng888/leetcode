import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        int[] pointers = new int[primes.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        dp[0] = 1;
        for(int i = 0; i < primes.length; i++){
            pq.add(new int[]{primes[i], i});
        }
        int[] cur = new int[2];
        for(int i = 1; i <= n; i++){
            cur = pq.peek();
            dp[i] = cur[0];
            while (!pq.isEmpty() && pq.peek()[0] == cur[0]){
                int k = pq.peek()[1];
                pq.poll();

                pointers[k]++;
                pq.add(new int[]{primes[k] * dp[pointers[k]], k});
            }
        }
        return dp[n-1];
    }
}
//1,2,4,7,8,13,14,16,19
