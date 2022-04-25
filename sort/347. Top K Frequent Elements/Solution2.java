import java.util.HashMap;

class Solution {
    HashMap<Integer,Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] res = new int[k];
        int l=-1,r=nums.length;
        while (l+1!=r){
            int m = l+(r-l)/2;
            if(count(m)<=k){
                r=m;
            }else{
                l=m;
            }
        }
        int f = r;
        int i=0;
        for(int key:map.keySet()){
            if(map.get(key)>=f){
                res[i++]=key;
            }
        }
        return res;
    }

    private int count(int m) {
        int res=0;
        for(int key:map.keySet()){
            if(map.get(key)>=m){
                res++;
            }
        }
        return res;
    }
}
