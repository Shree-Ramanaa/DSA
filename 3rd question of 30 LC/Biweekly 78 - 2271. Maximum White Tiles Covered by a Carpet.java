class Solution {
    public int maximumWhiteTiles(int[][] tiles, int len) {
        Arrays.sort(tiles,(a,b)->{return a[0]-b[0];});
        int res = 0;
        
        for(int i = 0 , j = 0, cover = 0; i < tiles.length && res < len; ){
            if(tiles[j][0] + len > tiles[i][1]){
                cover += tiles[i][1]-tiles[i][0]+1;
                res = Math.max(res,cover);
                i++;
            }
            else{
                 int partial = Math.max(0, tiles[j][0] + len - tiles[i][0]);
                 res = Math.max(res, cover + partial);
                 cover -= (tiles[j][1] - tiles[j][0] + 1);
                 ++j;
            }
        }
        
        return res;
    }
}
