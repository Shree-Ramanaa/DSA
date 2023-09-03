class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int dp[][] = new int[nums.length+1][2*total+1];
        dp[0][total]=1;
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<=2*total;j++){
                if(nums[i-1]<=j) dp[i][j] += dp[i-1][j - nums[i-1]];
                if(nums[i-1]+j <= 2*total) dp[i][j] += dp[i-1][nums[i-1]+j];
            }
        }
        
        return Math.abs(target)>total ? 0 : dp[nums.length][total+target];
    }
}
