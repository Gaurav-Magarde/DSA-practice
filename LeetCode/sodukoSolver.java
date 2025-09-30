class Solution {
    public static boolean flag;
    public boolean issafe(char[][] board,int i,int j,int n){
        for(int k = 0;k<9;k++){
            if(board[k][j]==(char)n) return false;
            if(board[i][k]==(char)n) return false;
        }
        int minrow = i/3;
        minrow*=3;
        int maxrow = minrow+3;
        while(minrow<maxrow){
            int mincol = j/3;
            mincol*=3;
            int maxcol = mincol+3;
            while(mincol<maxcol){
                if(board[minrow][mincol]==(char)n) return false;
                mincol++;
            }
            minrow++;
        }
        return true;
    }
    public boolean sudoku(char[][] board){
        for(int  i = 0;i<= 8;i++){
            for(int j =0 ;j<=8;j++){
                if(board[i][j]=='.'){
                    for(int  n = 49;n <= 57;n++){
                        if(issafe(board,i,j,n)){
                            board[i][j] = (char)n;
                            if(sudoku(board)){
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }    
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        sudoku(board);
    }
}