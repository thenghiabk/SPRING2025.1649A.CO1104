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
            Node tempNode = this.head;
            while (tempNode.next != null){
                tempNode = tempNode.next; // move to next node
            }
            tempNode.next = newNode; // add new node
        }

        this.size++;
    }

    @Override
    public E removeFirst () {

        // if list is empty
        if (this.head == null){
            throw new IllegalStateException("The list is empty.");
        }

        // if list is not empty
        E oldElement = this.head.element;
        Node tempNode = this.head;
        this.head = this.head.next;
        tempNode.next = null;
        this.size--;

        return oldElement;
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

class LinkedListADTRunner{
    public static void main ( String[] args ) {
        LinkedListADT<Integer> myLinkedList = new LinkedListADT<>();
        myLinkedList.addFirst( 10 );
        myLinkedList.addFirst( 20 );
        myLinkedList.addFirst( 30 );
        myLinkedList.addFirst( 40 );

        myLinkedList.addLast( 50 );
        myLinkedList.addLast( 60 );

        System.out.println(myLinkedList.removeFirst()); // 40
    }
}