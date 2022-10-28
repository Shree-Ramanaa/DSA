public class Solution {

    public int findMaxLength(int[] nums) {
         for(int i=0;i<nums.length;i+=1){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> m = new HashMap<>();
        
        m.put(0,-1);
        for(int i=0;i<nums.length;i+=1){
            sum = sum+nums[i];
            if(m.containsKey(sum)){
                int last = m.get(sum);
                max = Math.max(max, i-last);
            } else{
                m.put(sum, i);
            }
        }
        return max;
    }
}
