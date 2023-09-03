class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        boolean board[][] = new boolean[n][n];
        helper(board,0,0,n);
        return count;
    }

    private void helper(boolean board[][], int r, int c, int length){
        if(r>=length){
            count+=1;
            return;
        }
        if(c>=length){
            return;
        }

        if(isSafe(board,r,c,length)){
            board[r][c] = true;
            helper(board,r+1,0,length);
            board[r][c] = false;
        }

        helper(board,r,c+1,length);
    }

    private boolean isSafe(boolean board[][], int r, int c,int n){
        for(int i=r; i>-1; i-=1){
            if(board[i][c])return false;
        }

        for(int i=r,j=c; i>-1 && j>-1; i--,j--){
            if(board[i][j])return false;
        }

        for(int i=r,j=c; i>-1&&j<n; i--,j++){
            if(board[i][j])return false;
        }
        
        
        return true;
    }
}

