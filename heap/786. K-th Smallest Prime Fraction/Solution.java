import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return (arr[o1[0]]/arr[o1[1]]-arr[o2[0]]/arr[o2[1]]);
//            }
//        });
         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]);

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{i,n-1});
        }
        int[] pos = new int[2];
        int i = 0;
        while (k-->0 && !pq.isEmpty()){
            pos = pq.poll();
            if(k==0){
                break;
            }
            if(pos[1]-1 >=0){
                pq.add(new int[]{pos[0],pos[1]-1});
            }
        }
        return new int[]{arr[pos[0]],arr[pos[1]]};
    }
}
