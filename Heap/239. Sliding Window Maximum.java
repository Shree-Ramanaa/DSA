class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<>();
        int[] temp=new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
          temp[0]=nums[dq.peek()];
        
        for(int i=k;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peek()<=i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            temp[i-k+1]=nums[dq.peek()];
        }
        return temp;
    }
}
