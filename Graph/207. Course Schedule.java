class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
         int[] indegree = new int[n];
        List<Integer>result = new ArrayList<>();
        List<List<Integer>> g = new ArrayList<>();

        for(int i=0;i<n; i++){
            g.add(new ArrayList<>());
        }

        for(int i[]: prerequisites){
            g.get(i[1]).add(i[0]);
            indegree[i[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)if(indegree[i]==0)q.add(i);

        while(!q.isEmpty()){
            int i = q.poll();
            result.add(i);
            for(int j: g.get(i)){
                indegree[j]--;
                if(indegree[j]==0)q.add(j);
            }
        }
        
        return result.size() == n;
    }
}
