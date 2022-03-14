import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    int[] map;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        int sum = 0;
        map = new int[1 << 24];
        List<List<Integer>> specials = new ArrayList<>();
        for (int i = 0; i < special.size(); i++) {
            for (int j = 0; j < n; j++) {
                sum += special.get(i).get(j)*price.get(j);
            }
            if(sum > special.get(i).get(n)){
                specials.add(special.get(i));
            }
        }
        int state = 0;
        for (int i = 0; i < n; i++) {
            state += needs.get(i) << (4*i);
        }
        return dfs(price,specials,state);
    }

    private int dfs(List<Integer> price, List<List<Integer>> specials, int state) {
        if(map[state] != 0){
            return map[state];
        }
        int res = 0;
        int n = price.size();
        for (int i = 0; i < n; i++) {
            res += price.get(i)*((state >> (4*i))%16);
        }
        for (int i = 0; i < specials.size(); i++) {
            int flag = 1;
            for (int j = 0; j < n; j++) {
                if(specials.get(i).get(j) > (state >> (4*j))%16){
                    flag = 0;
                    break;
                }
            }
            if(flag == 0){
                continue;
            }else{
                int state2 = state;
                for (int j = 0; j < price.size(); j++) {
                    int num = specials.get(i).get(j);
                    state2 -=  num << (4*j);
                }
                res = Math.min(res,specials.get(i).get(n) + dfs(price,specials,state2));
            }
        }
        map[state] = res;
        return res;
    }
}
