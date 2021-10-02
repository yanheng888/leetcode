import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<HashMap<String,Integer>> stack = new Stack<>();
        HashMap<String,Integer> cur = new HashMap<>();
        int n = formula.length();
        for(int i = 0; i < n; i++){
            char ch = formula.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                int j = i + 1;
                while(j < n && Character.isLowerCase(formula.charAt(j))){
                    j++;
                }
                String key = formula.substring(i,j);
                i = j;
                while(j < n && Character.isDigit(formula.charAt(j))){
                    j++;
                }
                int num;
                if(i == j){
                    num = 1;
                }else{
                    num = Integer.parseInt(formula.substring(i,j));
                }
                cur.put(key,cur.getOrDefault(key, 0) + num);
                i = j - 1;
            }else if(ch == '('){
                stack.add(cur);
                cur = new HashMap<>();
            }else if(ch == ')'){
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
                cur = stack.pop();
                for(String key: temp.keySet()){
                    cur.put(key,cur.getOrDefault(key,0) + temp.get(key) * num);
                }//"K4(ON(SO3)2)2"

                i = j - 1;
            }//"Mg(OH)2","H2O"
        }
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

