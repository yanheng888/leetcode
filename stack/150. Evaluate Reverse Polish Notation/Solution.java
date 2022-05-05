import java.util.HashSet;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack();
        HashSet<String> st = new HashSet();
        st.add("*");
        st.add("+");
        st.add("-");
        st.add("/");
        for(String token:tokens){
            if(st.contains(token)){
                if(stk.size()>1){
                    int firstElement = stk.pop();
                    int secondElement = stk.pop();
                    stk.add(eval(secondElement,firstElement,token));
                }
            }else{
                stk.add(Integer.parseInt(token));
            }
        }
        return stk.peek();
    }
    public int eval(int num1,int num2,String operand){
        int res=0;
        if("*".equals(operand)){
            res = num1*num2;
        }else if("/".equals(operand)){
            res = num1/num2;
        }else if("+".equals(operand)){
            res = num1+num2;
        }else if("-".equals(operand)){
            res = num1-num2;
        }
        return res;
    }
}
