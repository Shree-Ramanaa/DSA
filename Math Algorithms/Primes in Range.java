 import java.util.*;

class PrimesInRange{
      public static void primesInRange(int n, boolean[] primes){
        
          for(int i = 2 ; i*i <= n ; i++){
            
              if(primes[i] == true){
                      for(int j = i*i ; j <= n ; j+=i){
                                        primes[j] = false;
                      }
              }
        }
    }
  
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
     
      boolean[] primes = new boolean[n+1];
      Arrays.fill(primes,true);
      primesInRange(n,primes);
      
      for(int i = 2 ; i <= n ; i++){
        if(primes[i] == true){
          System.out.print(i+" ");
        }
      }
  
   }
} 
