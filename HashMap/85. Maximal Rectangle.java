class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] height = new int[colLen];
        int maxArea = 0;
        
        for(int i = 0; i<rowLen; i+=1){
            for(int j = 0; j<colLen; j+=1){
                height[j] = matrix[i][j] == '1' ? height[j]+1 : 0;
            }
            
            maxArea = Math.max(maxArea,largestRectangleArea(height));
        }
        
        return maxArea;
    }
    
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
