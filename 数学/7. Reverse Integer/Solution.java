class Solution {
    public int reverse(int x) {
        if((x>0 && x < 10) || (x < 0 && x > -10) || x == 0){
            return x;
        }
        int res = 0;
        int sign = x/Math.abs(x);
        x = Math.abs(x);
        while (x > 0){
            if(res < Integer.MIN_VALUE/10 || res > Integer.MAX_VALUE/10){
                return 0;
            }
                res = res*10 + x % 10;
            x /= 10;
        }
        return res*sign;
    }
}
