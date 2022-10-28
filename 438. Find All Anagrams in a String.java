class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] h1 = new int[26], 
              h2 = new int[26];
        List<Integer> ans = new ArrayList();
        
        int len1 = s.length();
        int len2 = p.length();
        if(len2>len1)return ans;
        
        char[] sa = s.toCharArray(),
               pa = p.toCharArray();
        
        
        for(char i:pa)h2[i-'a']+=1;
        
        int diff = len2;
        
        for(int i=0; i<len2; i+=1){
            h1[sa[i] - 'a']+=1;
            if(h1[sa[i] - 'a'] > h2[sa[i] - 'a'])diff+=1;
            else diff-=1;
        }
        
        if(diff == 0)ans.add(0);
        int i = 0;
        
        for(int j = len2; j < len1 && i <= len1 - len2; i+=1, j+=1){
            int start = sa[i] - 'a';
            int end = sa[j] - 'a';
            
            if(h1[start] > h2[start])diff-=1;
            else diff+=1;
            
            h1[start] -= 1;
            
            if(h1[end] >= h2[end])diff+=1;
            else diff-=1;
            
            h1[end]+=1;
            
            if(diff==0)ans.add(i+1);
            //System.out.println(s.substring(i+1,i+1+len2)+" "+diff);
        }
           
        return ans;
    }
}
