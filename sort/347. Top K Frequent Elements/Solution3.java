import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int num:map.keySet()) {
            if(pq.size()!=k){
                pq.add(new int[]{num,map.get(num)});
            }else{
                if(!pq.isEmpty() && pq.peek()[1] < map.get(num)){
                    pq.poll();
                    pq.add(new int[]{num,map.get(num)});
                }
            }
        }
        int i=0;
        int[] res = new int[k];
        while (!pq.isEmpty()){
            res[i++] = pq.poll()[0];
        }
        return res;
    }
}
