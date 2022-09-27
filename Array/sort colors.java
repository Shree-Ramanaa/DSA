class Solution {
    public void sortColors(int[] nums) {
        int freq[] = new int[3];
        int n = nums.length;
        
        for(int i = 0 ; i < n; i++){
            freq[nums[i]]++;
        }
        
        for(int i = 0 , j = 0; i < 3 ; i++){
            while(freq[i]>0){
                nums[j++] = i;
                freq[i]--;
            }
        }
        
    }
}
