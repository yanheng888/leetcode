import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsStr = new String[n];
        for (int i = 0; i < n; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        String res = "";
        for (int i = 0; i < n; i++) {
            res += numsStr[i];
        }
        if(res.charAt(0) == '0'){
            return "0";
        }
        return res;
    }
}
