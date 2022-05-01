import java.util.HashMap;

class Solution {
    class trie{
        HashMap<Integer,trie> next = new HashMap<>();
    }
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int res = 0;
        trie root = new trie();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            trie temp = root;
            for (int j = i; j < n; j++) {
                if(nums[j] % p == 0){
                    cnt++;
                }
                if(cnt > k){
                    break;
                }
                if(!temp.next.containsKey(nums[j])){
                    temp.next.put(nums[j],new trie());
                    res++;
                }
                temp = temp.next.get(nums[j]);
            }
        }
        return res;
    }
}
