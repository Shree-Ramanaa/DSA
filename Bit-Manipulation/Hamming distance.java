class Solution {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y , count = 0;
        
        while(diff>0){
            diff &= diff - 1;
            count += 1;
        }
        
        return count;
    }
}
