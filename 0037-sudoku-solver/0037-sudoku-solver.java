class Solution {
    public void solveSudoku(char[][] board){
        solveSudoku(board, 0, 0);
    }
    public boolean solveSudoku(char[][] board, int iStart, int jStart){
        for(int i = iStart ; i < 9; i++, jStart = 0)	//自己没写对的地方：在i增加的时候，需要将jStart归零
            for(int j = jStart; j < 9; j++)
                if(board[i][j] == '.'){
                    for(char p = '1'; p <= '9'; p++){
                        if(isValidSudoku(board, i, j, p)){
                            board[i][j] = p;
                            if(solveSudoku(board, i, j+1))  return true;
                            else    board[i][j] = '.';
                        }
                    }
                    return false;
                }
        return true;
    }
    public boolean isValidSudoku(char[][] board, int row, int column, char num) {
        for(int i = 0; i < 9; i++){
            int tempRow = 3 * (row / 3) + i / 3;
            int tempCol = 3 * (column / 3) + i % 3;
            if(num == board[i][column])  return false;
            if(num == board[row][i]) return false;
            if(num != '.' && board[3 * (row / 3) + i / 3][ 3 * (column / 3) + i % 3] == num)
                return false;
        }
        return true;
    }
}