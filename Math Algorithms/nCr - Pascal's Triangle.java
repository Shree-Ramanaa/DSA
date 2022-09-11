public ArrayList<ArrayList<Integer>> getCombinationTable(int N){
    ArrayList<ArrayList<Integer>> pascalTriangle= new ArrayList();

    for(int i=0; i<=N; i++){
        ArrayList<Integer> pascalRow = new ArrayList();
        for(int j=0; j<=i; j++){
            if(j==0 || j==i){
                pascalRow.add(1);
            }else{
                pascalRow.add(pascalTriangle.get(i-1).get(j) + pascalTriangle.get(i-1).get(j-1));
            }
        }
        pascalTriangle.add(pascalRow);
    }
    return pascalTriangle;
}
