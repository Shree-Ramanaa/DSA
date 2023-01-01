class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n+1];
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<=n; i++)al.add(new ArrayList<>());
        for(int i[]:relations){
            al.get(i[0]).add(i[1]);
            indegree[i[1]]+=1;
        }
        
        Queue<Integer> pq = new LinkedList<>();
        for(int i=1;i<=n;i++)if(indegree[i]==0)pq.add(i);

        int sem = 0;
        while(!pq.isEmpty()){
            int size = pq.size();
            while(size-- > 0){
                int cur = pq.poll();
                n--;
                for(int neigh:al.get(cur)){
                    indegree[neigh]-=1;
                    if(indegree[neigh]==0)pq.add(neigh);
                }
            }
            sem++;
        }
        return n==0?sem:-1;
    }
}
