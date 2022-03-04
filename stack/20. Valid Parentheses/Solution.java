import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1){
            return false;
        }
        Stack<Character> stk = new Stack<>();
        for (char c: s.toCharArray()){
            if(c == '('){
                stk.push(')');
            }else if(c == '['){
                stk.push(']');
            }else if(c == '{'){
                stk.push('}');
            }else{
                if(stk.isEmpty() || stk.pop() != c){
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
