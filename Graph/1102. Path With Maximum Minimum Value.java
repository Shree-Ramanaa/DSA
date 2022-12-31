class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Integer [][] effort = new Integer[m][n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->
                Integer.compare(b[2],a[2])
        );
        
        pq.add(new int[]{0,0,grid[0][0]});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int a = cur[0];
            int b = cur[1];
            if(a==m-1 && n==b+1)return cur[2];
            for(int d[]:dirs){
                int na = a+d[0];
                int nb = b+d[1];
                if(isValid(na,nb,m,n)){
                    int eff = Math.min(cur[2],grid[na][nb]);
                    if(effort[na][nb] == null ||eff>effort[na][nb]){
                        effort[na][nb] = eff;
                        pq.add(new int[]{na,nb,effort[na][nb]});
                    }
                }
            }
        }
        return 0;
    }
    
    private Boolean isValid(int a,int b,int m,int n){
        return a<m && a>=0 && b<n && b>=0;
    }
}
