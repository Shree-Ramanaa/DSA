class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        
        for(int i = 0; i < col; i+=1){
            dp[0][i] = grid[0][i];
        }
        
        for(int i = 1; i < row; i+=1){
            for(int j = 0; j < col; j+=1){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < col; k+=1){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][k]+moveCost[grid[i-1][k]][j]+grid[i][j]);
                }
            }
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i:dp[row-1])ans=Math.min(ans,i);
        
        return ans;
    }
}
