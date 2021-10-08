import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
          //be careful! here should be while loop instead of if statement
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.add(nums2[i]);
        }
        int[] ret = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            ret[i] = map.getOrDefault(nums1[i],-1);
        }
        return ret;
    }
}
