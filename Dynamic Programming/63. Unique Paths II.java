class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        int[][] dp = new int[obs.length][obs[0].length];
        for(int r[]:dp)Arrays.fill(r,-1);
        return solve(obs,obs.length-1,obs[0].length-1,dp);
    }

    private int solve(int[][] obs, int m, int n, int[][] dp){
        if(m < 0 || n < 0 || obs[m][n] == 1){
            return 0;
        }
        if(dp[m][n] != -1)return dp[m][n];
        if(m==0 && n==0)return 1;

        int u = solve(obs,m-1,n,dp);
        int l = solve(obs,m,n-1,dp);

        return dp[m][n] = u+l;
    }
}
