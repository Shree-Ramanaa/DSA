class Solution {
    public int numIslands(char[][] grid) {
        
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        
        for(int i = 0; i < r; ++i)
        {
            for(int j = 0; j < c; ++j)
            {
                if(grid[i][j] == '1')
                {
                    ++count;
                    dfs(grid,r,c,i,j);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] mat, int r, int c, int i , int j)
    {
        if(i < 0 || j < 0 || i >= r || j >= c || mat[i][j] == '0')return;
        
        mat[i][j] = '0';
        
        dfs(mat,r,c,i+1,j);
        dfs(mat,r,c,i-1,j);
        dfs(mat,r,c,i,j-1);
        dfs(mat,r,c,i,j+1);
    }
}
