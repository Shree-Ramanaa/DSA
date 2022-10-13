class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0;
        int j = 0;
        while(i < n || j < n){
            while(i<n && start.charAt(i) == '_')
                i++;
            while(j<n && target.charAt(j) == '_')
                j++;
            
            if(i >= n && j >= n)
                return true;
            else if(i >=n || j >= n)
                return false;
            
            char s = start.charAt(i);
            char t = target.charAt(j);
            
            if(i == j && s != t)
                return false;
            
            if(i < j && (s != 'R' || t != 'R'))
                return false;
            
            if(i > j && (s != 'L' || t != 'L'))
                return false;
            
            i++;
            j++;
        }
        
        return true;
    }
}
