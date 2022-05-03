class Solution {
    public int lastRemaining(int n) {
        int a1 = 1, an = n,cnt = n,step = 1,k=1;
        while (cnt > 1){
            if(k%2 == 1){
                //left to right
                a1 += step;
            }else{
                a1 = (cnt%2 == 0) ? a1:a1+step;
            }
            cnt = (cnt>>1);
            step *= 2;
            k++;
        }
        return a1;
    }
}
