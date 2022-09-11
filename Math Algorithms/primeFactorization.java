public ArrayList<Integer> getPrimeFactors(int N){
	   
	   ArrayList<Integer> primeFactors = new ArrayList();
	   
	   for(int i=2; i*i<=N; i++){
                        while(N%i==0){
                                        N/=i;
                                        primeFactors.add(i);
                        }
        }
    
        if(N>1){
        primeFactors.add(N);
        }
          
    return primeFactors; 
	}
