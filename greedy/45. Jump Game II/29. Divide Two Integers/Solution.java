class Solution {
    public int divide(int dividend, int divisor) {
        long d1 = Math.abs((long)dividend);
        long d2 = Math.abs((long)divisor);
        int sign1 = dividend < 0 ? -1 : 1;
        int sign2 = divisor < 0 ? -1 : 1;
        long quotient = 0;
        while (d1 >= d2){
            long c = d2;
            long cnt = 1;
            while ((c << 1) <= d1){
                c = c << 1;
                cnt = cnt << 1;
            }
            quotient += cnt;
            d1 -= c;
        }
        if(sign1*sign2 == 1 && quotient > Integer.MAX_VALUE ){
            return Integer.MAX_VALUE;
        }else if(sign1*sign2 == -1 && quotient-1 > Integer.MAX_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)quotient*sign1*sign2;
    }
}
