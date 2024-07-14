// Basic structure of Doubly Linked List

class DoubleLinkedList{
    
    private Node head;
    private Node tail;
    private int size;
    
    public DoubleLinkedList(){
        this.size = 0;
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
