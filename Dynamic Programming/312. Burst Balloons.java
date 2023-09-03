class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        int len = arr.length;
        arr[0] = 1;
        arr[len-1] = 1;
        for(int i=1; i<len-1; i++){
            arr[i] = nums[i-1];
        }

        int[][] dp = new int[len][len];
        for(int row[]:dp)Arrays.fill(row,-1);

        return solve(arr,1,arr.length-2,dp);
    }

    private int solve(int[] nums, int i, int j, int[][] dp){
        if(i>j){
            return 0;
        }

        if(dp[i][j] != -1)return dp[i][j];

        int ans = 0;

        for(int k=i; k<=j; k++){
            ans = Math.max(ans, (nums[i-1]*nums[k]*nums[j+1]) + solve(nums,i,k-1,dp) + solve(nums,k+1,j,dp));
        }

        return dp[i][j] = ans;
    }
}
