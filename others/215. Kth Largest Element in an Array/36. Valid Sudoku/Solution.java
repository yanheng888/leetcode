class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][][] boxes = new int[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j]-'0';
                if(rows[i][num] != 0){
                    return false;
                }
                if(cols[j][num] != 0){
                    return false;
                }
                if(boxes[i/3][j/3][num] != 0){
                    return false;
                }
                rows[i][num]++;
                cols[j][num]++;
                boxes[i/3][j/3][num]++;
            }
        }
        return true;
    }
}
