// Doubly Linked List
// basic operations
// 1. Insertion - atHead, atEnd, atBetween
// 2. Deletion - atHead, atEnd, atBetween

class HelloWorld {
    public static void main(String[] args) {
        DoubleLinkedList dl = new DoubleLinkedList();
        
        dl.insertAtHead(10);
        dl.insertAtHead(20);
        dl.insertAtHead(30);
        dl.insertAtHead(40);
        dl.insertAtHead(50);
        dl.insertAtHead(60);
        dl.insertAtHead(70);
        dl.insertAtHead(80);
        dl.display();
        System.out.println(dl.getSize());
        
        System.out.println(dl.deleteFromHead());
        System.out.println(dl.deleteFromHead());
        dl.display();
        System.out.println(dl.getSize());
        
        System.out.println(dl.deleteFromEnd());
        System.out.println(dl.deleteFromEnd());
        dl.display();
        System.out.println(dl.getSize());
        
        
        System.out.println(dl.deleteFrom(3));
        System.out.println(dl.deleteFrom(6));
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
    
    public int deleteFromHead(){
        if(this.head == null){
            System.err.println("Empty List!");
            return -1;
        }
        int val = this.head.data;
        this.head = this.head.next;
        if(this.head == null) this.tail = null;
        else this.head.prev = null;
        this.size--;
        return val;
    }
    
    public int deleteFromEnd(){
        if(this.head == null){
            System.err.println("Empty List!");
            return -1;
        }
        int val = this.tail.data;
        this.tail = this.tail.prev;
        if(this.tail == null) this.head = null;
        else this.tail.next = null;
        this.size--;
        return val;
    }
    
    public int deleteFrom(int index){
        if(index < 0 || index >=this.size){
            System.err.println("Invalid Index!");
            return -1;
        }
        if(index == 0) return deleteFromHead();
        if(index == this.size-1) return deleteFromEnd();
        
        Node temp = head;
        for(int i=0; i< index-1; i++){
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        this.size--;
        return val;
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
