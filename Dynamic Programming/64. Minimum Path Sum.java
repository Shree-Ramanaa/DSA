class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int[] row:dp)Arrays.fill(row,-1);

        return solve(grid, grid.length-1, grid[0].length-1,dp);
    }

    private int solve(int[][] grid, int i, int j, int[][] dp){

        //reached the destination
        if(i==0 && j==0)return grid[0][0];

        //outBound so returning the max val tht a cell can hold
        if(i<0 || j<0)return 201;

        //retreive if result calculated already
        if(dp[i][j] != -1)return dp[i][j];

        //else calc both possibilities
        int up = grid[i][j] + solve(grid,i-1,j,dp);
        int left = grid[i][j] + solve(grid,i,j-1,dp);
        
        //store and return the min out the both possibilities
        return dp[i][j] = Math.min(up,left);
    }
}
