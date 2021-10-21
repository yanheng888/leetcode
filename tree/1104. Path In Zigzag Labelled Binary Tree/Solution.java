import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> ret = new ArrayList<>();
        while(label !=0){
            ret.add(label);
            int lev = (int)( Math.floor(Math.log(label) / Math.log(2)));
            label = (int)(Math.pow(2, lev - 1) + Math.pow(2, lev) - 1 - label/2);
        }
        int n = ret.size();
        for(int i = 0; i < n / 2; i++){
            int temp = ret.get(i);
            ret.set(i, ret.get(n - 1 - i));
            ret.set(n - 1 - i, temp);
        }
        return ret;
    }
}
