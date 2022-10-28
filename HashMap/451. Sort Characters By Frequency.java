class Solution {
    public String frequencySort(String s) {
        int[] memo = new int[256];
        int idx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            idx = (int) s.charAt(i);
            memo[idx]++;
        }
        
        int max, c;
        StringBuilder sb = new StringBuilder();
        while (true) {
            c = -1;
            max = -1;
            for (int j = 0; j < 256; j++) {
                if (memo[j] != 0) {
                    if (memo[j] > max) {
                        max = memo[j];
                        c = j;
                    }
                }
            }
            
            if (c == -1)
                break;
            memo[c] = 0;
            
            for (int i = 0; i < max; i++)
                sb.append((char) c);
        }
        
        return sb.toString();
    }
}
