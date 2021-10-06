import java.util.Stack;

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int small = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < preorder.length; i++){
            if(small > preorder[i]){
                return false;
            }
            while (!stack.isEmpty() && preorder[i] > stack.peek()){
              //update value to be equal to root value. Thus, if the right node of root is less than root  return false
                small = stack.pop();
                
            }
            stack.add(preorder[i]);
        }
        return true;
    }
}
