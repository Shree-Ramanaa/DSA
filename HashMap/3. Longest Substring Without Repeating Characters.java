class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int maxLen = 0;
        for(int left = 0, right = 0; right < s.length(); right++){
            char cRight = s.charAt(right);
            map[cRight]++;
            while(map[cRight] > 1){
                map[s.charAt(left++)]--;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
