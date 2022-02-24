class Solution {
    public int numOfWays(int n) {
        int M = 1000000007;
        long c2 = 6, c3 = 6;
        for (int i = 1; i < n; i++) {
            long temp2 = c2, temp3 = c3;
            c2 = ((3*temp2)%M+(2*temp3)%M)%M;
            c3 = ((2*temp2)%M+(2*temp3)%M)%M;
        }
        return (int)(c3+c2)%M;
    }
}
