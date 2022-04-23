class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0){
            return false;
        }
        int n = matrix[0].length;
        int x=0,y=n-1;
        while(x<m && y>= 0){
            int num = matrix[x][y];
            if(num == target){
                return true;
            }else if(num > target){
                y--;
            }else{
                x++;
            }
        }
        return false;
    }
}
