// Linked-List Implementation
// 1. Insertion - atHead, atEnd, atIndex

class HelloWorld {
    public static void main(String[] args){
        CustomLinkedList l1 = new CustomLinkedList();
        l1.insertAtEnd(10);
        l1.insertAtEnd(20);
        l1.insertAtHead(30);
        l1.insertAtHead(40);
        l1.insertAt(60, 0);
        l1.insertAt(70, l1.getSize()-1);
        l1.insertAt(80, 3);
        
        System.out.println(l1);
    }

}

class CustomLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public CustomLinkedList(){
        this.size = 0;
    }
    
    public void insertAtHead(int data){
        // first insertion
        if(this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        }
        else{
            // create a new node which points to currentHead
            // then update the currentHead to New Node
            this.head = new Node(data, this.head);
        }
        this.size++;
    }
    
    public void insertAtEnd(int data){
        // first insertion, both head, tail will be null
        if(this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        }
        else{
            // create a new node and make tail's next point to new node
            // update tail to new Node
            this.tail.next = new Node(data);
            this.tail = this.tail.next;
        }
        this.size++;
    }
    
    // considering 0 index as head node, size-1 as tail
    public void insertAt(int data, int index){
        if(index < 0 || index >= this.size){
            System.err.println("Invalid Index!");
        }
        else{
            if(index == 0) insertAtHead(data);
            else if (index == this.size-1) insertAtEnd(data);
            else{
                Node temp = head;
                for(int i = 0; i < index-1; i++){
                    temp = temp.next;
                }
                temp.next = new Node(data, temp.next);
            }
            this.size++;
        }
    }
    
    
    
    public int getSize(){
        return this.size;
    }
    
    // Overloading toString of Object so that SOUT works directly;
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while(temp != null){
            sb.append(temp.data + "->");
            temp = temp.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
    
    private class Node{
        private int data;
        private Node next;
        
        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
