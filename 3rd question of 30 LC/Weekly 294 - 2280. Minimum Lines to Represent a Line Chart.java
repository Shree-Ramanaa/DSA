class Solution {
    public int minimumLines(int[][] stockPrices) {
            int n = stockPrices.length;
            if(n == 1 || n == 2) return n - 1;
    
   
            Arrays.sort(stockPrices,(a,b) ->{
                    return a[0] - b[0];
            });

    
            int x2 = stockPrices[1][0];
            int x1 = stockPrices[0][0];
    
            int y2 = stockPrices[1][1];
            int y1 = stockPrices[0][1];
    
    
            int dx = x2 - x1;
            int dy = y2 - y1;

            int lines = 1;
    
            for(int i=2;i<n;i++){
        
            int x4 = stockPrices[i][0];
            int x3 = stockPrices[i-1][0];
        
            int y4 = stockPrices[i][1];
            int y3 = stockPrices[i-1][1];
         
            int dx1 = (x4 - x3);
            int dy1 = (y4 - y3);
        
            if(dx1*dy != dx*dy1) lines++;
            dy = dy1;
            dx = dx1;
            }
        return lines;
    }
}
