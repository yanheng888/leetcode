class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int res = 0;
        for(int i=0;i<n;i++){
            int num = arr[i];
            map.put(num,map.getOrDefault(num-diff,0)+1);
            res = Math.max(res,map.get(num));
        }
        return res;
    }
}
