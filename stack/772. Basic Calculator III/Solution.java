import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder curStr = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                continue;
            }else if(ch == '('){
                stack.add(curStr);
                curStr = new StringBuilder();
            }else if(ch == ')'){
                curStr = stack.pop().append(eval(curStr));
            }else{
                curStr.append(ch);
            }
        }
        return eval(curStr);
    }//"(2+6*3+5-(3*14/7+2)*5)+3"

    private int eval(StringBuilder str) {
        str.insert(0,'+');
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '+' || ch == '-'){
                int j = i + 1;
                if(str.charAt(j) == '+' || str.charAt(j) == '-'){
                    j++;
                }
                while (j < str.length() && Character.isDigit(str.charAt(j))){
                    j++;
                }
                int number = Integer.parseInt(str.substring(i+1,j));
                if(ch == '+'){
                    stack.add(number);
                }else if(ch == '-'){
                    stack.add(-1*number);
                }
                i = j - 1;
            }else if(ch == '*' || ch =='/'){
                int j = i + 1;
                if(str.charAt(j) == '+' || str.charAt(j) == '-'){
                    j++;
                }
                while (j < str.length() && Character.isDigit(str.charAt(j))){
                    j++;
                }
                int number = Integer.parseInt(str.substring(i+1,j));
                if(ch == '*'){
                    stack.add(stack.pop() * number);
                }else if(ch == '/'){
                    stack.add(stack.pop() / number);
                }
                i = j - 1;
            }
        }
        while (!stack.isEmpty()){
            ret += stack.pop();
        }
        return ret;
    }
}
