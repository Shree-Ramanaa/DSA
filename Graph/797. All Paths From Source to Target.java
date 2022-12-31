class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,0,graph.length-1,new ArrayList<>(),0);
        return res;
    }

    private void dfs(int[][] g,int s, int d,List<Integer> al,int i){
        al.add(s);
        if(s==d){
            res.add(new ArrayList<>(al));
            return;
        }
        for(int a:g[s]){
            dfs(g,a,d,al,i+1);
            al.remove(i+1);
        }
    }
}
