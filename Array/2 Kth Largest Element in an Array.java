class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2)->n2-n1);
        
        for(int i :nums)maxHeap.add(i);
        for(int i = 1; i <k;i++)maxHeap.poll();
        return maxHeap.peek();
    }
}
