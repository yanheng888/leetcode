import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class StockPrice {
    HashMap<Integer,Integer> map;
    PriorityQueue<int[]> minHeap;
    PriorityQueue<int[]> maxHeap;
    int curTime;
    public StockPrice() {
        map = new HashMap<>();
        curTime = -1;
        minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
    }

    public void update(int timestamp, int price) {
        curTime = Math.max(curTime, timestamp);
        map.put(timestamp, price);
        maxHeap.offer(new int[]{price, timestamp});
        minHeap.offer(new int[]{price, timestamp});
    }

    public int current() {
        if(!map.containsKey(curTime)){
            return -1;
        }
        return map.get(curTime);
    }

    public int maximum() {
        while (!maxHeap.isEmpty()){
            int[] priceTimePair = maxHeap.peek();
            int price = priceTimePair[0];
            int timeStamp = priceTimePair[1];
            if(map.get(timeStamp) == price){
                return price;
            }
            maxHeap.poll();
        }
        return -1;
    }

    public int minimum() {
        while (!minHeap.isEmpty()){
            int[] priceTimePair = minHeap.peek();
            int price = priceTimePair[0];
            int timeStamp = priceTimePair[1];
            if(map.get(timeStamp) == price){
                return price;
            }
            minHeap.poll();
        }
        return -1;

    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
