class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        int sum = 0;
        int minLen = 100001;
        
        while(j < n){
            sum+=nums[j];
            while(sum>=target){
                minLen = minLen>j+1-i ? j+1-i : minLen;
                sum -= nums[i++];
            }
            j++;
        }
        return minLen == 100001 ? 0 : minLen;
    }
}
