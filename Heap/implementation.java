//MaxHeap
public class MaxHeap
{
    private int[] maxHeap;
    private int size = 0;
    private int maxSize;
    
    public MaxHeap(int maxSize){
        this.maxSize = maxSize;
        maxHeap = new int[maxSize+1];
    }
    
    private void swap(int from, int to){
        maxHeap[from] ^= maxHeap[to];
        maxHeap[to] ^= maxHeap[from];
        maxHeap[from] ^= maxHeap[to];
    }
    
    private int positionOfParent(int pos){
        return pos/2;
    }
    
    private int positionOfLeftChild(int pos){
        return pos*2;
    }
    
    private int positionOfRightChild(int pos){
        return pos*2 + 1;
    }
    
    public int peek(){
        return maxHeap[1];
    }
    
    public boolean insert(int n){
        if(size==maxSize)return false;
        else{
            size +=1;
            maxHeap[size] = n;
            int current = size;
            
            while(current>1 && maxHeap[current] > maxHeap[positionOfParent(current)]){
                swap(current,positionOfParent(current));
                current = positionOfParent(current);
            }
        }
        return true;
    }
    
    private void heapify(int pos){
        if(pos > size/2 || pos > size)return;
        
        if(maxHeap[pos]<maxHeap[positionOfLeftChild(pos)]){
            swap(pos,positionOfLeftChild(pos));
            heapify(positionOfLeftChild(pos));
        }
        else if(maxHeap[pos]<maxHeap[positionOfRightChild(pos)]){
            swap(pos,positionOfRightChild(pos));
            heapify(positionOfRightChild(pos));
        }
    }
    
    public int pop(){
        int ret = maxHeap[1];
        maxHeap[1] = maxHeap[size];
        size-=1;
        heapify(1);
        return ret;
    }
    
}
