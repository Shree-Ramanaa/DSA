class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
                return 0;
            }
            int sum = 0;
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            map.put(0, 1);
            for (int i = 0; i < nums.length; i= i+1) {
                sum = sum + nums[i];
                count += map.getOrDefault(sum - k, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        
    }
}
