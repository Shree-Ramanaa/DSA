class Solution {
    public int largestCombination(int[] candidates) {
        int[] bits = new int[32];
        
        for(int i : candidates){
            int t=0;
            
            while((i>>t) > 0 && t < 32){
                if(((i>>t)&1)==1){
                    bits[t]+=1;
                }
                t+=1;
            }
        }
        
        int ans=0;
        for(int i:bits)ans=Math.max(i,ans);
        return ans;
    }
}
