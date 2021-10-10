import java.util.Stack;

class Solution {
    public int calculate(String s) {
        s = process(s);
        Stack<Integer> stack = new Stack<>();
        Integer sum = 0;
        Integer sign = 1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '+' || ch == '-'){
                int j = i + 1;
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    j++;
                }
                int number = Integer.parseInt(s.substring(i+1,j));
                number = ch == '+' ? number : -number;
                stack.add(number);
                i = j - 1;
            }else if(ch == '*' || ch == '/'){//" 3+5 / 2 ";
                int j = i + 1;
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    j++;
                }
                int number = Integer.parseInt(s.substring(i+1,j));
                if(!stack.isEmpty()){
                    number = ch == '*' ? stack.pop() * number : stack.pop()/number;
                }
                stack.add(number);
                i = j - 1;
            }
        }
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    private String process(String s){
        StringBuilder ret = new StringBuilder();
        ret.append("+");
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                continue;
            }
            ret.append(ch);
        }
        return ret.toString();
    }
}
