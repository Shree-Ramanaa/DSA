class Solution {
    public int singleNumber(int[] nums) {
        
        int len = nums.length;
        int ans = 0;
        
        for(int i = 0 ; i <= 31 ; i++){
            
            int ctr = 0;
            
            for(int j = 0 ; j < len ; ++j){
                
                if( (nums[j] & (1 << i)) != 0){
                        ctr++;                    
                }
            }
            
            if(ctr % 3 == 1)ans |= (1<<i);
        }
        
        return ans;
    }
}
