package L01_LinkedListADT;

public class LinkedListADT<E> implements AbtractLinkedList<E> {
    private Node head;

    // constructor
    public LinkedListADT(){
        this.head = null;
    }

    @Override
    public void addFirst ( E element ) {
        Node newNode = new Node( element );

        if (head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }


    }

    @Override
    public void addLast ( E element ) {

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
