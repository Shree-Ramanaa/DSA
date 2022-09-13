void insertionSort(ArrayList<Integer>arr, int val){
    arr.add(val);

    for(int i=arr.size()-1; i>=1; i--){
        if(arr.get(i)>arr.get(i-1)){
            break;
        }
        swap(i, i-1, arr);
    }
}
