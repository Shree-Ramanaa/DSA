class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for(int no:nums){
            totalSum += no;
        }

        if((totalSum & 1) == 1)
            return false;

        int halfSum = totalSum/2;
        boolean dp[][] = new boolean[nums.length+1][halfSum+1];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j <= halfSum; j++){
                if(j - nums[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
                dp[i][j] |= dp[i - 1][j];
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }

        return dp[nums.length][halfSum];
    }
}
