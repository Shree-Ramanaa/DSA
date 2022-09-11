public void bubbleSort(int[] arr){
    for(int i=0; i<arr.length-1; i++){
        bool isSwap = false;
        for(int j=arr.length-1; j>i; j--){
            if(arr[j]<arr[j-1]){
                swap(j,j-1,arr);
                isSwap = true;
            }
        }
        if(!isSwap){
            break;
        }
    }
}

public void swap(int a , int b , int[] arr){
    arr[a] ^= arr[b];
    arr[b] ^= arr[a];
    arr[a] ^= arr[b];
}

/*
Time Complexity:
---------------
Worst Case : O(N^2) => Array already sorted in our revered codition
Best Case : O(N) => Array already sorted
Average Case : O(N^2) => Array elements arranged in random order
*/
