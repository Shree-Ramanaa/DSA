class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap();
        
        for(char i:s.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
        (a,b) -> b.getValue() - a.getValue());
        
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            pq.add(e);
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(!pq.isEmpty()){
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) 
                ans.append(e.getKey());
        }
        
        return ans.toString();
    }
}
