package L01_LinkedListADT;

public class LinkedListADT<E> implements AbtractLinkedList<E> {
    private Node head;
    private Node tail;
    private int size;

    // constructor
    public LinkedListADT(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst ( E element ) {
        Node newNode = new Node( element );

        // if list is empty
        if (this.head == null && this.tail == null){
            this.head = newNode;
            this.tail = newNode;
        } else { // if list is not empty
            newNode.next = this.head;
            this.head = newNode;
        }

        this.size++;
    }

    @Override
    public void addLast ( E element ) {
        Node newNode = new Node( element );

        // if list is empty
        if (this.head == null && this.tail == null){
            this.head = newNode;
            this.tail = newNode;
        } else { // if list is not empty
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.size++;
    }

    @Override
    public E removeFirst () {

        // if list is empty
        if (this.head == null && this.tail == null){
            throw new IllegalStateException("The list is empty.");
        }

        E oldElement = this.head.element;

        // if list has only one element
        if (this.head == this.tail){
            this.head = null;
            this.tail = null;
        } else { // if list has more than one element
            Node tempNode = this.head;
            this.head = this.head.next;
            tempNode.next = null;
        }

        this.size--;

        return oldElement;
    }

    @Override
    public E removeLast () {
        if (this.head == null && this.tail == null){
            throw new IllegalStateException("The list is empty.");
        }

        E oldElement = this.tail.element;

        // if list has only one element
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else { // if list has more than one element
            Node tempNode = this.head;
            while (tempNode.next != this.tail) {
                tempNode = tempNode.next;
            }

            tempNode.next = null;
            this.tail = tempNode;

        }
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