class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> values = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(values.containsKey(target - nums[i])){
                int[] res = new int[]{i, values.get(target - nums[i])};
                return res;
            }
            values.put(nums[i], i);
        }
        
        return new int[2];
    }
}
