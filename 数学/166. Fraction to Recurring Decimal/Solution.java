class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long,Integer> map = new HashMap<>();
        long sign = 1;
        long A = numerator;
        long B = denominator;
        if(numerator==0){
            return "0";
        }
        if(numerator<0){
            sign *= -1;
        }
        if(denominator<0){
            sign *= -1;
        }
        A = Math.abs(A);
        B = Math.abs(B);
        StringBuilder res = new StringBuilder();
        if(sign<0){
            res.append("-");
        }
        res.append(A/B);
        if(A%B==0){
            return res.toString();
        }
        res.append(".");
        long C = A%B;
        while(C!=0 && !map.containsKey(C)){
            map.put(C,res.length());
            res.append(""+C*10/B);
            C = (C*10)%B;
        }
        if(C == 0){
            return res.toString();
        }
        res.insert(map.get(C),"(");
        res.append(")");
        return res.toString();
    }
}
