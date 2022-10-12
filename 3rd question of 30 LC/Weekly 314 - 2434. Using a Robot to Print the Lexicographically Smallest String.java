class Solution {
    public String robotWithString(String s) {
        
        int len = s.length();
        int arr[] = new int[len];
        for(int i = 0; i < len; i+=1){
            arr[i] = s.charAt(i) - 'a';
        }
        int min[] = new int[len];
        
        for(int i = len-1; i >= 0; i-=1){
            min[i] = arr[i];
            
            if(i < len-1){
                min[i] = Math.min(min[i],min[i+1]);
            }
            
        }
        
        Stack<Integer> st = new Stack();
        StringBuilder ans = new StringBuilder("");
        
        for(int i = 0; i < len; i+=1){
            st.push(arr[i]);
            
            while(!st.isEmpty() && (i==len-1 || st.peek() <= min[i+1])){
                ans.append((char)(st.pop()+'a'));
            }
        }
       
        return ans.toString();
    }
}
