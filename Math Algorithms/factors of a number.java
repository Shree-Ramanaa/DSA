public ArrayList<Integer> factorsOfNumber(int n){
  ArrayList<Integer> arr = new ArrayList();
   for(int i=1; i*i<=val; i++){
        if(val%i==0){
            arr.add(i);
            if(val/i != i){
                arr.add(val/i);
            }
        }
   }
     return arr;
}
