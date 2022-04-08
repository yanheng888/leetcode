import java.util.Arrays;
import java.util.Collections;

import static java.lang.Long.toBinaryString;

class Solution {
    public boolean isUnique(String s) {
        int map = 0;
        for (int i = 0; i < s.length(); i++) {
            int move_bit = s.charAt(i)-'a';
            if((map & (1 << move_bit)) != 0){
                return false;
            }
            map |= (1 << move_bit);

        }
        return true;
    }
}
