import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<HashMap<String,Integer>> stack = new Stack<>();
        
        //save current string into map, key is atom and val is frequency
        HashMap<String,Integer> cur = new HashMap<>();
        int n = formula.length();
        
        for(int i = 0; i < n; i++){
            char ch = formula.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                //get the atom full name, while loop is to get lower case char
                int j = i + 1;
                while(j < n && Character.isLowerCase(formula.charAt(j))){
                    j++;
                }
                String key = formula.substring(i,j);
                
                //get the digit, ex. H2
                i = j;
                while(j < n && Character.isDigit(formula.charAt(j))){
                    j++;
                }
                
                //if there is no digit after atmo, by default is 1
                int num;
                if(i == j){
                    num = 1;
                }else{
                    num = Integer.parseInt(formula.substring(i,j));
                }
                cur.put(key,cur.getOrDefault(key, 0) + num);
                
                //since for loop will add 1
                i = j - 1;
            }else if(ch == '('){
                //once ch is '(', save cur and reset cur. Thus, when ch is ')', we can get previous cur and concatenate two map
                stack.add(cur);
                cur = new HashMap<>();
            }else if(ch == ')'){
                //generally, when using stack to solve '()'problem, '(' means add element to stack and ')' means pop element out of stack
                // i + 1 is element after ')', while loop to get digit after ')'
                int j = i + 1;
                while(j < n && Character.isDigit(formula.charAt(j))){
                    j++;
                }
                int num;
                String s = formula.substring(i+1,j);
                if(s.length() != 0){
                    num = Integer.parseInt(formula.substring(i+1,j));
                }else{
                    num = 1;
                }

                HashMap<String, Integer> temp = cur;
                //concatenate two map
                cur = stack.pop();
                for(String key: temp.keySet()){
                    cur.put(key,cur.getOrDefault(key,0) + temp.get(key) * num);
                }

                i = j - 1;
            }
        }
        //since Hashmap's keyset() is unsorted, we need to sort it. Then loop over all key, generate a required string
        String result = "";
        Object[] keyArr = cur.keySet().toArray();
        Arrays.sort(keyArr);
        for (Object key: keyArr)
        {
            result += key;
            if(cur.get(key) > 1){
                result += String.valueOf(cur.get(key));
            }
        }
        return result;
    }
}

