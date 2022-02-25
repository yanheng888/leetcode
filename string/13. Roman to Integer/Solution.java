import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = map.get(c);
            if(i+1 < s.length() && val < map.get(s.charAt(i+1))){
                res -= val;
            }else{
                res += val;
            }
        }
        return res;
    }
}
