import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stk = new LinkedList<>();
        int n = num.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            while (!stk.isEmpty() && stk.peek() > ch && cnt < k){
                cnt++;
                stk.pop();
            }
            stk.push(ch);
        }
        while (!stk.isEmpty() && cnt < k){
            stk.pop();
            cnt++;
        }
        while (!stk.isEmpty() && stk.peekLast() == '0'){
            stk.pollLast();
        }
        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()){
            res.append(stk.pollLast());
        }
        if(res.length() == 0){
            return "0";
        }
        return res.toString();
    }
}
