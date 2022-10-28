class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList();
        
        if(strs == null)return ans;
        
        Map<String,Integer> map = new HashMap();
        int in = 0;
        
        for(String i : strs){
            
            String k = getKey(i);
            if(!map.containsKey(k)){
                    map.put(k,in);
                    List<String> s = new ArrayList();
                    s.add(i);
                    ans.add(s);
                    in+=1;
            }
            else{
                ans.get(map.get(k)).add(i);
            }
            
        }
        
        return ans;
    }
    
     public String getKey(String str) {
        char[] arr = new char[26];
        
        for(int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            arr[c - 'a'] ++;
        }
        
        return new String(arr);
    }
}
