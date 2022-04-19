class Solution {
    HashMap<Integer,Integer> map = new HashMap();
    public int integerReplacement(int n) {
        if(n==1){
            return 0;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n%2 == 0){
            map.put(n,1+integerReplacement(n/2));
        }else{
            map.put(n,2+Math.min(integerReplacement(n/2),integerReplacement(n/2+1)));
        }
        return map.get(n);
    }
}
