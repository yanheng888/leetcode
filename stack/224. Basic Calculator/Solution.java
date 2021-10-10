import java.util.Stack; 

class Solution { 
    public int calculate(String s) { 
 	//处理字符串 “(1+(4+5+2)-3)” -> “+(+1+(+4+5+2)-3)” 
        s = process(s);
        Stack<Integer> signs = new Stack<>(); 
        Stack<Integer> nums = new Stack<>(); 
        Integer sum = 0;
        Integer sign = 1; 

        for(int i = 0; i < s.length(); i++){ 
            char ch = s.charAt(i); 
            if(ch == '('){ 
                //save sign and sum before current new () 
                signs.add(sign); 
                nums.add(sum); 
                sum = 0; //reset sum, only calculate the sum of current () 
            }else if(ch == ')'){ 
                //pre sum + current sum * sign before current () 
                sum = nums.pop() + sum * signs.pop();  
            }else if(ch == '+' || ch == '-'){ 
                sign = ch == '+' ? 1 : -1; 
            }else{ 
                int j = i; 
                while(j < s.length() && Character.isDigit(s.charAt(j))){ 
                    j++; 
                } 
                sum += sign * Integer.parseInt(s.substring(i,j)); 
                i = j - 1; // for loop will add 1, so j - 1 
            } 
        } 
        return sum; 
    } 

    private String process(String s){ 
        StringBuilder ret = new StringBuilder(); 

        for(int i = 0; i < s.length(); i++){ 
            char ch = s.charAt(i); 
            if(ch == ' ' || ch == '\n'){ 
                continue; 
            } 
            ret.append(ch); 
            if(ch == '('){ 
                ret.append('+'); 
            } 
        } 
        return ret.toString(); 

    } 

} 
