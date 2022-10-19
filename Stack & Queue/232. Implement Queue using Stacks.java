class MyQueue {

    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    private int front;
    
    public void push(int x) {
        if(s1.isEmpty())front=x;
        s1.push(x);    
    }
    
    public int pop() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int ans = 0;
        if(!s2.isEmpty()){
            ans=s2.pop();
        }
        front = s2.isEmpty()?-1:s2.peek();
        while(!s2.isEmpty())s1.push(s2.pop());
        return ans;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
