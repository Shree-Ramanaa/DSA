class Solution {
    public int minimumCost(int n, int[][] connections) {
        //creating a graph
        List<List<int[]>> al = new ArrayList<>();
        for(int i=0;i<=n;i++)al.add(new ArrayList<>());
        for(int[] con:connections){
            al.get(con[0]).add(new int[]{con[1],con[2]});
            al.get(con[1]).add(new int[]{con[0],con[2]});
        }
        //visited set
        HashSet<Integer> visited = new HashSet<>();
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,1});

        while(visited.size()!=n){
            if(pq.isEmpty())return -1;
            int[] cur = pq.poll();
            int node = cur[1];
            int dist = cur[0];
            if(!visited.add(node))continue;
            cost+=dist;

            for(int[] neigh:al.get(node)){
                if(visited.contains(neigh[0]))continue;
                pq.add(new int[]{neigh[1],neigh[0]});
            }
        }

        return cost;
    }
}
