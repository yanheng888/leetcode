import java.util.*;

class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        for (int num: tasks){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int res = 0;
        for (Integer key: map.keySet()){
            if(map.get(key) == 1){
                return -1;
            }
            res += (map.get(key)+2)/3;
        }
        return res;
    }

}
