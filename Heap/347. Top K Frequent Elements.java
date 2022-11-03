class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums.length == k)return nums;
        Map<Integer,Integer> freq = new HashMap();
        
        for(int i:nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = 
            new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue()); 

        for(Map.Entry<Integer,Integer> entry: freq.entrySet()) {
            pq.add(entry);
            if(pq.size() > k)
                pq.poll();
        }
        
        
        int[] ans = new int[k];
        
        for(int i=k-1; i>=0; i-=1){
            ans[i] = pq.poll().getKey();
        }
        
        return ans;
    }
}
