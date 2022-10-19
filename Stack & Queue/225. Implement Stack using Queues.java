class MyStack {
    private int top = -1;
    private int size = 0;
    Queue<Integer> q = new LinkedList();
    
    public void push(int x) {
        q.add(x);
        top = x;
        size+=1;
    }
    
    public int pop() {
        int i = 1;
        while(i<size){
            if(i==size-1)top = q.peek();
            q.add(q.remove());
            i+=1;
        }
        size -= 1; 
        return q.remove();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return size == 0;
    }
}
