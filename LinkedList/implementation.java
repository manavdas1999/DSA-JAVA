// Implementation of Linked List in java.

class CustomLinkedList {
    
    // Linked List's head, tail pointers.
    private Node head;
    private Node tail;
    // maintains current size of Linked List.
    private int size;
    
    // constructor of Linked List starting with size 0.
    public CustomLinkedList(){
        this.size = 0;
    }
  
    // As Node is only used with LinkedList, we are defining it as inner class of Linked List.
    private class Node{
        private int data;
        private Node next;
        
        // constructor 1
        public Node(int data){
            this.data = data;
            // by default Node next remains null.
        }
        // constructor 2
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
