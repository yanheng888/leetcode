import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if(k == 0){
            return res;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if(pq.peek() > arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            res[k-1-i] = pq.poll();
        }
        return res;
    }
}
