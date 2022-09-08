class Solution {
    public int[] countBits(int n) {
        int[] numberOfOnes = new int[n+1];
        
        for(int i = 1; i <= n; ++i){
               numberOfOnes[i] = numberOfOnes[i/2] + i%2;
        }
        return numberOfOnes;
    }
}
