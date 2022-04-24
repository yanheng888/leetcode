import java.util.*;

class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] rec:rectangles){
            List<Integer> lst = map.getOrDefault(rec[1], new ArrayList<>());
            lst.add(rec[0]);
            map.put(rec[1],lst);
        }
        for (int key:map.keySet()){
            Collections.sort(map.get(key));
        }
        int[] res = new int[points.length];
        int j=0;
        for(int[] point:points){
            int l = point[0];
            int h = point[1];
            int cnt = 0;
            for (int i = h; i < 101; i++) {
                if(map.containsKey(i)){
                    cnt += map.get(i).size()-bfs(map.get(i),l);
                }
            }
            res[j++]=cnt;
        }
        return res;
    }

    private int bfs(List<Integer> nums, int l) {
        int low=-1,high=nums.size();
        while (low+1 != high){
            int mid = low+(high-low)/2;
            if(nums.get(mid) < l){
                low = mid;
            }else{
                high = mid;
            }
        }
        return high;
    }
}
