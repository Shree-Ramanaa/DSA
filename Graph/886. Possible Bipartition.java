class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i =0; i<n+1; i++)g.add(new ArrayList<>());
        for(int i[]:dislikes){
            g.get(i[0]).add(i[1]);
            g.get(i[1]).add(i[0]);
        }
        int colors[] = new int[n+1];
        Arrays.fill(colors,0);
        for(int i=1; i<1+n;i++){
            if(colors[i]==0 && !dfs(g,colors,i,1)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> g, int[] colors, int node, int color){
        colors[node] = color;
        boolean res = true;
        for(int i:g.get(node)){
            if(colors[i]==-color)continue;
            if(colors[i]==color)return false;
            res = res && dfs(g,colors,i,-color);
        }
        return res;
    }
}
