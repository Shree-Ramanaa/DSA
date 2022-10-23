class Node{
    public int val;
    Node next;
    
    public Node(int val){
        this.val = val;
        next = null;
    }
}

class MyLinkedList {
    private Node head;
    private int len = 0;
    
    public MyLinkedList() {
    }
    
    public int get(int index) {
        if(index>=len)return -1;
        Node temp = head;
        
        int i = 0;
        while(i<index){
            i+=1;
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        if(head == null){
            head = new Node(val);
        }
        else{
            Node nn = new Node(val);
            nn.next = head;
            head = nn;
        }
        len+=1;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            head = new Node(val);
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            Node nn = new Node(val);
            temp.next = nn;
        }
        len+=1;
    }
    
    public void addAtIndex(int index, int val) {
        
        if(index > len)return;
        
        if(index == len){
            addAtTail(val);
            return;
        }
        
        if(index == 0){
            addAtHead(val);
            return;
        }
        
        int i = 1;
        Node temp = head;
        
        while(i<index){
         i+=1;
         temp = temp.next;
        }
        
        Node nn = new Node(val);
        nn.next = temp.next;
        temp.next = nn;
        len+=1;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= len)return;
        
        if(index == 0){
            head = head.next;
            len-=1;
            return;
        }
        
        Node temp = head;
        
        if(index == len-1){
            while(temp.next.next != null){
            temp = temp.next;
            }
            temp.next = temp.next.next;
            len-=1;
            return;
        }
        
        int i = 1;
        while(i<index){
            temp=temp.next;
            i+=1;
        }
        temp.next = temp.next.next;
        len-=1;
    }
}

