import java.util.*;

class Solution {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;
    HashMap<Integer,Integer> map;
    public double getK(int k){
        if(k%2==1){
            return small.peek()*1.0;
        }
        return (small.peek()*1.0+big.peek()*1.0)*0.5;
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        ArrayList<Double> arr = new ArrayList<>();
        small = new PriorityQueue(Collections.reverseOrder());
        big = new PriorityQueue();
        map = new HashMap();
        for(int i=0;i<k;i++){
            small.add(nums[i]);
        }
        for(int i=0;i<k/2;i++){
            big.add(small.poll());
        }
        arr.add(getK(k));
        for(int i=k;i<nums.length;i++){
            int balance = 0;
            if(nums[i-k] <= small.peek()){
                balance--;
            }else{
                balance++;
            }
            map.put(nums[i-k],map.getOrDefault(nums[i-k],0)+1);

            if(nums[i] <= small.peek()){
                small.add(nums[i]);
                balance++;
            }else{
                big.add(nums[i]);
                balance--;
            }
            if(balance>0){
                big.add(small.poll());
            }
            if(balance<0){
                small.add(big.poll());
            }
            while(!small.isEmpty() && map.getOrDefault(small.peek(),0) > 0){
                map.put(small.peek(),map.get(small.peek())-1);
                small.poll();
            }
            while(!big.isEmpty() && map.getOrDefault(big.peek(),0) > 0){
                map.put(big.peek(),map.get(big.peek())-1);
                big.poll();
            }
            arr.add(getK(k));
        }
        double[] res = new double[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}
