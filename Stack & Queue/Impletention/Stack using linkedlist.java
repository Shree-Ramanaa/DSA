class MyStack {
    LinkedList<Integer> st;
    private int size = 0;
    
    public MyStack(){
        st = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        st.addFirst(x); // add at begining
        size += 1;
    }
    
    public int pop() {
        size -= 1;
        return st.poll(); // remove at begining
    }
    
    public int top() {
        return st.peek(); // returns the head node value
    }
    
    public boolean empty() {
        return size == 0;
    }
}
