class Solution {
    private static final int max = 200;
    
    public int countDistinct(int[] nums, int k, int p) {
       
        ArrayList<int[]> child = new ArrayList();
        child.add(new int[max+1]);
        int n = nums.length;
        int i = 0;
        int ans = 0, nxt = 1;
        
        while(i < n){
            
            int j = i, node = 0;
            int count = 0;
            while(j<n){
                int c = nums[j];
                if (c % p == 0) if (count++ == k) break;
                j+=1;
                if(child.get(node)[c] == 0){
                    ans+=1;
                    child.get(node)[c] = nxt;
                    nxt+=1;
                    child.add(new int[max+1]);
                }
                node = child.get(node)[c];
            }
           i+=1; 
        }
        
        return ans;    
    }
}
