import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {
    Stack<Integer> stack;
    ArrayList<Integer> arr;
    int i;
    int ret;
    public StockSpanner() {
        stack = new Stack<>();
        arr= new ArrayList<>();
        i = 0;
        ret = 0;
    }

    public int next(int price) {
        arr.add(price);
        if(stack.isEmpty() || arr.get(stack.peek()) > arr.get(i)){
            ret = 1;
        }else{
            while (!stack.isEmpty() && arr.get(stack.peek()) <= arr.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                ret = i + 1;
            }else{
                ret = i - stack.peek();
            }
        }
        stack.add(i);
        i++;
        return ret;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
