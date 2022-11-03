class KthLargest {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i : nums) add(i);
    }
    
    public int add(int val) {
        if(pq.size() < this.k){
            pq.add(val);
        }else if(val > pq.peek()){
            pq.remove();
            pq.add(val);

        }

        return pq.peek();
    }
}
