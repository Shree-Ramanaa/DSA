class NumArray {
    int[] prefix = new int[10000];
    int len;
    public NumArray(int[] nums) {
        len = nums.length;
        prefix[0] = nums[0];
        for(int i = 1; i < len; i++){
            prefix[i]=nums[i]+prefix[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return left == 0 ? prefix[right] : prefix[right]-prefix[left-1];
    }
}
