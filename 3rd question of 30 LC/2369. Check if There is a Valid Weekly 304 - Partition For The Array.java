class Solution {
    public boolean validPartition(int[] nums) {
        
        int n = nums.length;
        if(n == 2)return nums[1] == nums[0];
        
        boolean dp[] = new boolean[n+1];
        
        if(nums[1] == nums[0])dp[1] = true;
        if((nums[1] == nums[0] && nums[2] == nums[1]) || (nums[1] == nums[0] + 1 && nums[1] == nums[2]-1))dp[2] = true;
        
        for(int i = 3; i<n; i+=1){
            if(nums[i-1] == nums[i])dp[i] |= dp[i-2];
            if(nums[i] == nums[i-1] && nums[i-1] == nums[i-2])dp[i] |= dp[i-3];
            if(nums[i] == nums[i-1]+1 && nums[i] == nums[i-2]+2)dp[i] |= dp[i-3];
        }
        return dp[n-1];
    }
}
