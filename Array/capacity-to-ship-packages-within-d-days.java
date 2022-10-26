class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = 0;
        int max = 0;
        for(int i:weights){
            sum+=i;
            if(max<i)max=i;
        }
        if(days == 1)return sum;
        if(days == n)return max;
        int high = sum, low = max;
        int ans = Integer.MAX_VALUE;
        while(high >= low){
           int mid = low + (high-low)/2;
           int d = 1;
           int s = 0;
           
           for(int i:weights){
               s+=i;
               if(s>mid){
                   s=i;
                   d+=1;
               }
           }
           
            if(d<=days){
               ans=mid;
               high = mid-1;
            }
            else if(d>days)low=mid+1;
            else high = mid-1;
        }
        return ans;
    }
}
