class Solution {
    private boolean res;
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        int wordLen = word.length();
        for(int i = 0; i<r; i+=1){
            for(int j = 0; j<c; j+=1){
                res = false;
                if(board[i][j] == word.charAt(0))dfs(board,i,j,r,c,word,1,wordLen);
                if(res)return true;
            }
        }
        return false;
    }

    private void dfs(char[][] board, int i, int j, int r, int c, String word, int index, int wordLen){
        
        if(index == wordLen){
            res=true;
            return;
        }
        
        if(i==r || i==-1 || j==-1 || j==c)return;
        if(res == true)return;

        if(i+1<r && board[i+1][j]==word.charAt(index)){
            board[i][j] = '1';
            dfs(board,i+1,j,r,c,word,index+1,wordLen);
            board[i][j] = word.charAt(index-1);
        }
        if(j<c-1 && board[i][j+1] == word.charAt(index)){
            board[i][j] = '1';
            dfs(board,i,j+1,r,c,word,index+1,wordLen);
            board[i][j] = word.charAt(index-1);
        }
        if(j>0 && board[i][j-1] == word.charAt(index)){
            board[i][j] = '1';
            dfs(board,i,j-1,r,c,word,index+1,wordLen);
            board[i][j] = word.charAt(index-1);
        }
        if(i>0 && board[i-1][j] == word.charAt(index)){
            board[i][j] = '1';
            dfs(board,i-1,j,r,c,word,index+1,wordLen);
            board[i][j] = word.charAt(index-1);
        }
    }
}
