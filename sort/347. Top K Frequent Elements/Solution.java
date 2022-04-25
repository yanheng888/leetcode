import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

class Solution {
    Random random;
    HashMap<Integer,Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        random = new Random();
        map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<int[]> arr = new ArrayList<>();
        for (int key:map.keySet()){
            arr.add(new int[]{key,map.get(key)});
        }
        int f = quickSelect(arr,0,arr.size()-1,k);
        int[] res = new int[k];
        int i=0;
        for(int key:map.keySet()){
            if(map.get(key)>=f){
                res[i++]=key;
            }
        }
        return res;
    }


    private int quickSelect(ArrayList<int[]> arr,int l,int r,int k) {
        int pivot = arr.get((r+l)/2)[1];
        int i=l,t=l,j=r;

        while (t<=j){
            if(arr.get(t)[1] > pivot){
                mySwap(arr,j,t);
                j--;
            }else if(arr.get(t)[1] < pivot){
                mySwap(arr,t,i);
                t++;
                i++;
            }else {
                t++;
            }
        }
        if(r-j>=k){
            return quickSelect(arr,j+1,r,k);
        }else if(r-i+1>=k){
            return pivot;
        }else{
            return quickSelect(arr,l,i-1,k-(r-i+1));
        }
    }



    private void mySwap(ArrayList<int[]> nums, int i, int j) {
        int[] temp = nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }
}
