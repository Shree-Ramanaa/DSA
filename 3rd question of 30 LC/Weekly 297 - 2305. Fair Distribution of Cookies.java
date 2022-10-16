class Solution {
    int k;
    int c[];
    int kval[];
    
    public int distributeCookies(int[] cookies, int k) {
        this.k = k;
        this.c = cookies;
        this.kval = new int[k];
        return solve(0);
    }
    
    public int solve(int in){
        if(in == c.length){
            int res = 0;
            for(int i : kval)res=Math.max(res,i);
            return res;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k; i+=1){
            kval[i]+=c[in];
            res = Math.min(res,solve(in+1));
            kval[i]-=c[in];
        }
        return res;
    }
}
