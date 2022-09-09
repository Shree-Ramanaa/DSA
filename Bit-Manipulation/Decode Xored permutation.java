class Solution {
    public int[] decode(int[] encoded) {
        
        int first = 0;
        int n = encoded.length;
        
        for(int i = 1 ; i <= n + 1; ++i){
                first ^= i;
        }
        
        for(int i = 1 ; i <= n ; i+=2){
                first ^= encoded[i];
        }
        
        int[] ans = new int[n+1];
        ans[0] = first;
        
        for(int i = 1 ; i < n+1 ; i++){
                ans[i] = ans[i-1]^encoded[i-1];
        }
        
        return ans;
    }
}
