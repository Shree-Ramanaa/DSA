class Solution {
    public int minDistance(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length(); 
        int[][] dp = new int[len1+1][len2+1];

        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(s1,s2,len1-1,len2-1,dp);
    }

    public int solve(String s1, String s2, int i, int j, int[][] dp){
        if(i<0 && j<0)return 0;

        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        char c1 = s1.charAt(i), c2 = s2.charAt(j);
        int ins = Integer.MAX_VALUE, del = Integer.MAX_VALUE, rep = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        
        if(c1 == c2){
            ans = solve(s1,s2,i-1,j-1,dp);
        }else{
            ins = 1 + solve(s1,s2,i,j-1,dp);
            del = 1 + solve(s1,s2,i-1,j,dp);
            rep = 1 + solve(s1,s2,i-1,j-1,dp);

            ans = Math.min(ans,ins);
            ans = Math.min(ans,del);
            ans = Math.min(ans,rep);            
        }

        return dp[i][j] = ans;
    }
}
