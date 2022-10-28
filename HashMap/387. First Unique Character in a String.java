class Solution {
    public int firstUniqChar(String s) {
       int[] hash = new int[26];
       int len = s.length();
        
       for(int i = 0; i<len; i+=1){
           hash[s.charAt(i)-'a']+=1;
       }
       for(int i = 0; i<len; i+=1){
           if(hash[s.charAt(i)-'a']==1)return i;
       }
        return -1;
    }
}
