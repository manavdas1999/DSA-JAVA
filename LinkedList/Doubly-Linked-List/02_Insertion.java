// Doubly Linked List
// basic operations
// 1. Insertion - atHead, atEnd, atBetween

class HelloWorld {
    public static void main(String[] args) {
        DoubleLinkedList dl = new DoubleLinkedList();
        
        dl.insertAtHead(10);
        dl.insertAtHead(20);
        dl.insertAtHead(30);
        dl.insertAtHead(40);
        dl.display();
        System.out.println(dl.getSize());
        
        dl.insertAtEnd(10);
        dl.insertAtEnd(20);
        dl.insertAtEnd(30);
        dl.insertAtEnd(40);
        dl.display();
        System.out.println(dl.getSize());
        
        dl.insertAt(11, 0);
        dl.insertAt(12, dl.getSize()-1);
        dl.insertAt(13, 1);
        dl.insertAt(14, 3);
        dl.display();
        System.out.println(dl.getSize());
    }
}


class DoubleLinkedList{
    
    private Node head;
    private Node tail;
    private int size;
    
    public DoubleLinkedList(){
        this.size = 0;
    }
    
    public void insertAtHead(int data){
        if(this.head == null){
            // first insertion
            this.head = new Node(data);
            this.tail = this.head;
        }
        else{
            this.head.prev = new Node(data, this.head, null);
            this.head = this.head.prev;
        }
        this.size++;
    }
    
    public void insertAtEnd(int data){
        if(this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        }
        else{
           this.tail.next = new Node(data, null, this.tail);
           this.tail = this.tail.next;
        }
        this.size++;
    }
    
    public void insertAt(int data, int index){
        if(index < 0 || index >= this.size){
            System.err.println("Invalid Index!");
        }
        else if(index == 0) insertAtHead(data);
        else if(index == this.size-1) insertAtEnd(data);
        else{
            Node temp = head;
            for(int i=0; i<index-1; i++){
                temp = temp.next;
            }
            temp.next.prev = new Node(data, temp.next, temp);
            temp.next = temp.next.prev;
            this.size++;
        }
    }
    
    public void display(){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    
    public void displayReversed(){
        Node temp = tail;
        while(temp!= null){
            System.out.print(temp.data + "->");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
    
    public int getSize(){
        return this.size;
    }
    
    private class Node{
        private int data;
        private Node next;
        private Node prev;
        
        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node next, Node prev){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    
}
