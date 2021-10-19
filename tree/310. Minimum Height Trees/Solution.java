import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>(n);

        for(int i = 0; i < n; i++){
            set.add(i);
        }
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0], b = edges[i][1];
            map.putIfAbsent(a, new ArrayList<>(Arrays.asList(b)));
            map.putIfAbsent(b, new ArrayList<>(Arrays.asList(a)));
        }

        LinkedList<Integer> que = new LinkedList<>();
        for(int k : map.keySet()){
            if(map.get(k).size() == 1){
                que.add(k);
            }
        }

        while (set.size() > 2){
            int len = que.size();
            for(int k = 0; k < len; k++){
                Integer cur = que.poll();
                set.remove(cur);
                for(int next: map.get(cur)){
                    map.get(next).remove(cur);
                    
                    if(map.get(next).size() == 1){
                        que.add(next);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
