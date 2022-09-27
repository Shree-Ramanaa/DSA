class Solution {
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE;
        int profit = 0;
        int possibleProfit = 0;
        
        for(int price:prices){
            
            if(price < min){
                min = price;
            } 
             
            possibleProfit = price - min;
            
            if(possibleProfit > profit){
                profit = possibleProfit;
            }
        }
        
        return profit;
    }
}
