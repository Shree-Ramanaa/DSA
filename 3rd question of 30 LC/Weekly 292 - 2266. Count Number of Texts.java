class Solution {
    private static final int mod = 1_000_000_007;
    
    public int countTexts(String pressedKeys) {
        
        char s[] = pressedKeys.toCharArray();
        int n = s.length;
        int dp[] = new int[n+1];
        dp[0] = 1;
        
        for(int i = 1; i<=n; i+=1){
            char c = s[i-1];
            dp[i] = dp[i-1];
            
            if(i>=2 && c==s[i-2]){
                        dp[i]=(dp[i]+dp[i-2])%mod;
            
                    if(i>=3 && c==s[i-3]){
                        dp[i]=(dp[i]+dp[i-3])%mod;
            
                    if(i>=4 && (c=='7' || c=='9') && c == s[i-4]){
                        dp[i]=(dp[i]+dp[i-4])%mod;
                    }
                }
            }
        }
    return dp[n];
    }
}
