import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        ArrayList<int[]> diff = new ArrayList<>();
        for (int[] trip:trips){
            diff.add(new int[]{trip[1],trip[0]});
            diff.add(new int[]{trip[2],-trip[0]});
        }
        int total = 0;
        Collections.sort(diff, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]-o2[0] != 0){
                    return o1[0]-o2[0];
                }else{
                    return o1[1]-o2[1];
                }

            }
        });

        for(int[] dif:diff){
            total += dif[1];
            if(total > capacity){
                return false;
            }
        }
        return true;
    }
}
