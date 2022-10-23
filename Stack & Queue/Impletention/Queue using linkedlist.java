class MyQueue {
    private LinkedList<Integer> queue;
    private int size = 0;

    public MyQueue() {
        queue = new LinkedList();
    }
    
    public void push(int x) {
        queue.add(x); // adds at last of the list
        size += 1;
    }
    
    public int pop() {
        size -= 1;
        return queue.poll();
    }
    
    public int peek() {
        return queue.peek();
    }
    
    public boolean empty() {
        return size == 0;
    }
}
