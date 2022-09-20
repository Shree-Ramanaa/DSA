void countingSort(int a[], int n) 
{  
   int output[n+1];  
   int max = getMax(a, n);  
   int count[max+1]; 
  
  
  for (int i = 0; i <= max; ++i)   
  {  
    count[i] = 0;
  }  
    
  for (int i = 0; i < n; i++)
  {  
    count[a[i]]++;  
  }  
  
   for(int i = 1; i<=max; i++)   
      count[i] += count[i-1];
 
  for (int i = n - 1; i >= 0; i--) {  
    output[count[a[i]] - 1] = a[i];  
    count[a[i]]--; 
  }  
  
   for(int i = 0; i<n; i++) {  
      a[i] = output[i]; 
   }  
}  
