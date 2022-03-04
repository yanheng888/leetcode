class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0){
            return true;
        }
        int y = 0;
        int xx = x;
        while (xx > 0){
            y = y * 10 + xx%10;
            xx /= 10;
        }
        return y == x;
    }
}
