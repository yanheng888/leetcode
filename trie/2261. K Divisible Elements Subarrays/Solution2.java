import java.util.HashSet;

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int res = 0;
        HashSet<String> st = new HashSet<>();
        for(int i = 0;i < n;i++){
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if(nums[j] % p == 0){
                    cnt++;
                }
                if(cnt > k){
                    break;
                }
                String key = getS(nums,i,j);
                if(!st.contains(key)){
                    res++;
                    st.add(key);
                }
            }
        }
        return res;
    }

    private String getS(int[] nums,int i, int j) {
        StringBuilder res = new StringBuilder();
        for (int k = i; k <= j; k++) {
            res.append(nums[k]).append(",");
        }
        return res.toString();
    }

    private int count(int[] nums, int i, int j, int p) {
        int cnt = 0;
        for (int k = i; k <= j; k++) {
            if(nums[k] == nums[k]/p*p){
                cnt++;;
            }
        }
        return cnt;
    }
}
