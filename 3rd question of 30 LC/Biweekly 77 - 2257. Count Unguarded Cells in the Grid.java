class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] res = new int[m][n];   
        int result = 0, cnti, cntj;
        for(int[] i : walls){       
            res[i[0]][i[1]] = 2;
        }
        for(int[] i : guards){      
            res[i[0]][i[1]] = 1;  
        }
        for(int i = 0; i < res.length;i++){
            for(int j = 0; j < res[i].length;j++){
                if(res[i][j] == 1){    
                    cnti = i;   
                    cntj = j;  
                    while(cnti-1 != -1 && res[cnti-1][cntj] != 2 && res[cnti-1][cntj] != 1){ 
                        res[cnti-1][cntj] = 3;
                        cnti--;
                    }
                    cnti = i;  
                    while(cnti+1 != m && res[cnti+1][cntj] != 2 && res[cnti+1][cntj] != 1){  
                        res[cnti+1][cntj] = 3;
                        cnti++;
                    }
                    cnti = i;  
                    while(cntj-1 != -1 && res[cnti][cntj-1] != 2 && res[cnti][cntj-1] != 1){  
                        res[cnti][cntj-1] = 3;
                        cntj--;
                    }
                    cntj = j;  
                    while(cntj+1 != n && res[cnti][cntj+1] != 2 && res[cnti][cntj+1] != 1){ 
                        res[cnti][cntj+1] = 3;
                        cntj++;
                    }
                }
            }
        }
        for(int[] i : res){  
            for(int j : i){
                if(j == 0){   
                    result++;
                }
            }
        }
        return result;  
    }
}
