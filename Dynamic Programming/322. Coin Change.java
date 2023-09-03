class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] r:dp)Arrays.fill(r,-1);

        int res = solve(coins,coins.length-1,amount,dp);
        return amount !=0 && res == Integer.MAX_VALUE-1 ? -1 : res;
    }

    public int solve(int[] coins, int i, int amount, int[][] dp){
        if(amount == 0)return 0;
        if(i<0 || amount < 0)return Integer.MAX_VALUE-1;
        if(dp[i][amount]!=-1)return dp[i][amount];
        int s = 0;
        if(amount>0){
        s = 1+solve(coins,i,amount-coins[i],dp);
        }
        int c = 0 + solve(coins,i-1,amount,dp);

        return dp[i][amount] = Math.min(s,c);
    }
}
