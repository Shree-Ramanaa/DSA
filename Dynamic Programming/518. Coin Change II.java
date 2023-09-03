class Solution {
    int[][] dp;
    
    public int change(int amount, int[] coins) {
        dp = new int[amount+1][coins.length];
        for(int[] r:dp)Arrays.fill(r,-1);
        return solve(amount, coins, 0);
    }

    private int solve(int amount, int[] coins, int i){
        if(coins.length == i || amount < 0){
            return 0;
        }

        if(dp[amount][i] != -1)return dp[amount][i];
        if(amount == 0)return 1;

        return dp[amount][i] = solve(amount-coins[i],coins,i) + solve(amount,coins,i+1);
    }
}
