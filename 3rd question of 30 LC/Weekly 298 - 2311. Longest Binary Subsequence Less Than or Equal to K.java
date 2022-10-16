class Solution {
    public int longestSubsequence(String s, int k) {
        int p = 1;
        char[] c = s.toCharArray();
        int num = 0;
        int ans=0;
        for(int i = c.length-1; i>=0; i-=1){
            if(c[i]=='0')ans+=1;
            else if(num+p<=k){
                num+=p;
                ans+=1;
            }
            if(p<1000000000)p*=2;
        }
        return ans;
    }
}
