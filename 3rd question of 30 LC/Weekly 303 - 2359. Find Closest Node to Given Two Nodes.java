class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int A[] = new int[n];
        int B[] = new int[n];
    
        Arrays.fill(A,Integer.MAX_VALUE);
        Arrays.fill(B,Integer.MAX_VALUE);
        
        dfs(edges,node1,A);
        dfs(edges,node2,B);
        
        int res = Integer.MAX_VALUE;
        int node = -1;
        
        for(int i = 0; i < n; i+=1){
            if(A[i]==Integer.MAX_VALUE || B[i]==Integer.MAX_VALUE) continue;
            if(res>Math.max(A[i],B[i])){
                node=i; 
                res= Math.max(A[i],B[i]);
            }
        }
        
        return node;
    }
    
    public void dfs(int[] edges, int s, int[] p){
        int dis = 0;
        
        while(s!=-1 && p[s] == Integer.MAX_VALUE){
            p[s] = dis;
            dis+=1;
            s = edges[s];
        }
    }
}
