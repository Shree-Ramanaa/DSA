class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] dsuf= new int[n];
        Arrays.fill(dsuf, -1);
        for(int[] e: edges){
            union(e[0], e[1], dsuf);
        }
        int comp = 0;
        for(int i=0;i<n;i++){
            if(dsuf[i] == -1)
                comp++;
        }
        return comp;
    }
    boolean union(int u,int v,int[] dsuf){
        int pu = find(u,  dsuf);
        int pv= find(v, dsuf);
        if(pu==pv) return false;
        else{
            dsuf[pu] = pv;
            return true;
        }
    }
    int find(int node,int[] dsuf){
        if(dsuf[node]==-1) return node;
        return dsuf[node] = find(dsuf[node], dsuf);
    }
}
