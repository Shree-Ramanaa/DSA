class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<int []>> g = new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i[]:flights){
            g.get(i[0]).add(new int[]{i[1],i[2]});
        }
        
        int[] steps = new int[n];
        Arrays.fill(steps,Integer.MAX_VALUE);
        
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.add(new int[] {src,0,0});
        
        
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            if(arr[1]>steps[arr[0]] || arr[1]>k+1)continue;
            if(arr[0]==dst)return arr[2];
            steps[arr[0]]=arr[1];
            for(int[] p:g.get(arr[0])){
                    int cost = arr[2]+p[1];
                    pq.add(new int[]{p[0],arr[1]+1,cost});
            }
        }
        return -1;
    }
}
