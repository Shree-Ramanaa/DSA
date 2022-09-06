class Solution {
    public int singleNumber(int[] nums) {
     int result=0;
        for(int num=0;num<nums.length;num++){
            result=result^nums[num];
        }
        return result;
    }
}
