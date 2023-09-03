class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m+1][n+1];
        for(int[] row: dp)Arrays.fill(row,-1);

        //Going top-down so our destination will be 0,0
        return solve(m-1,n-1,dp);
    }

    private int solve(int m, int n, int[][] dp){

        //reached destination a valid path
        if(m==0 && n == 0)return 1;

        //out of bound invalid path
        if(m<0 || n<0)return 0;

        //retreive result if already calculated
        if(dp[m][n] != -1)return dp[m][n];

        //calculating ways from both paths up and down
        int up = solve(m-1,n,dp);
        int left = solve(m,n-1,dp);

        //storing and returning the sum of ways 
        return dp[m][n] = up+left;
    }
}
