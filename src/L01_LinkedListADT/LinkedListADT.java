package L01_LinkedListADT;

public class LinkedListADT<E> implements AbtractLinkedList<E> {
    private Node head;
    private int size;

    // constructor
    public LinkedListADT(){
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst ( E element ) {
        Node newNode = new Node( element );

        if (this.head != null){
            newNode.next = head;
        }

        this.head = newNode;
        this.size++;
    }

    @Override
    public void addLast ( E element ) {
        Node newNode = new Node( element );

        if (this.head == null){
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }

        this.size++;
    }

    private class Node {
        // data
        private E element;
        private Node next;

        // constructor
        public Node ( E element ) {
            this.element = element;
            this.next = null;
        }
    }
}
