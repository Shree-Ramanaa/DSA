class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length + 1, m = nums2.length + 1;
        int[][] dp = new int[n][m];
        int maxLen = 0;

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(nums1[i - 1] == nums2[j - 1])dp[i][j] = dp[i-1][j-1] + 1;
                if(dp[i][j] > maxLen)maxLen = dp[i][j];
            }
        }

        return maxLen;
    }
}
