class MedianFinder {
    PriorityQueue<Integer> maxHeap,minHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> (b-a));
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return minHeap.size() == maxHeap.size() ?
            (maxHeap.peek() + minHeap.peek())/2.0 :
            minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }
}
