import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o2[1]-o1[1];
                }
            }
        });
        int[][] res = new int[people.length][];
        for(int[] person:people){
            int spaces = person[1]+1;
            for (int i = 0; i < people.length; i++) {
                if(res[i] == null){
                    spaces--;
                    if(spaces==0){
                        res[i] = person;
                        break;
                    }
                }

            }
        }
        return res;
    }
}
