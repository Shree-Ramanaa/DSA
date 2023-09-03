class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int a = 2; a<=n; a++){
            dp[a] = 0;
            for(int i = 0, j = a-1; i<a; i++,j--){
                dp[a] += dp[i]*dp[j];
            }
        }

        return dp[n];
    }
}
