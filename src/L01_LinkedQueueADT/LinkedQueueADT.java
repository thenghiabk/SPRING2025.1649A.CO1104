package L01_LinkedQueueADT;

/**
 * This class implements the AbstractLinkedQueue interface to create a
 * linked list based queue data structure. The queue is a First In First Out (FIFO)
 * data structure, meaning the first element added is the first one to be removed.
 * The class provides methods to add and remove elements from the queue, as well as
 * to check the size and emptiness of the queue.
 */

public class LinkedQueueADT<E> implements AbstractLinkedQueue<E> {
    // Reference to the first node in the queue
    private Node head;

    // Reference to the last node in the queue
    private Node tail;

    // The current number of elements in the queue
    private int size;

    // constructor
    public LinkedQueueADT (){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an element to the end of the queue and increases the size.
     * If the queue is empty, the new element becomes the head and tail.
     * @param element the element to be added
     */
    @Override
    public void offer ( E element ) {

        // makes a new node
        Node newNode = new Node( element );

        // if queue is empty
        if (this.head == null && this.tail == null){
            // set both head and tail to new node
            this.head = newNode;
            this.tail = newNode;
        } else { // if queue is not empty
            // set the next of the tail to the new node
            this.tail.next = newNode;
            // set the tail to the new node
            this.tail = newNode;
        }

        this.size++;
    }

    /**
     * Removes and returns the first element from the queue.
     * If the queue is empty, throws an IllegalStateException.
     * @return the element that was removed from the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public E poll() {
        if (this.head == null && this.tail == null) {
            throw new IllegalStateException("The queue is empty.");
        }

        E oldElement = this.head.element;

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            Node tempNode = this.head;
            this.head = this.head.next;
            tempNode.next = null;
        }

        this.size--;

        return oldElement;
    }


    /**
     * Returns the first element in the queue without removing it.
     * If the queue is empty, throws an IllegalStateException.
     *
     * @return the first element in the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public E peek() {
        if (this.head == null && this.tail == null) {
            throw new IllegalStateException("The queue is empty.");
        }
        return this.head.element;
    }

    @Override
    public int size () {
        return this.size;
    }

    @Override
    public boolean isEmpty () {
        // returns true if the queue is empty and false otherwise
        return (this.head == null && this.tail == null);
    }

    /**
     * Converts the queue to a string representation.
     * @return a string representation of the queue, with elements separated by commas
     */
    @Override
    public String toString () {
        // create a string builder to efficiently build up a string
        StringBuilder result = new StringBuilder();
        result.append( "[" );

        // iterate through the nodes in the queue
        Node tempNode = this.head;
        while(tempNode != null){
            result.append( tempNode.element );
            if(tempNode.next != null){
                result.append( ", " );
            }

            tempNode = tempNode.next;
        }

        result.append( "]" );

        return result.toString();
    }

    /**
     * Node class for use in the LinkedQueueADT.
     * <p>
     * This class represents a node in the linked list.
     * It contains a reference to the element being stored and a reference to the next node in the list.
     */
    private class Node {
        // data
        private E element; // the actual element stored in the node
        private Node next;

        // constructor
        public Node ( E element ) {
            this.element = element;
            this.next = null;
        }
    }

}

class LinkedQueueADTRunner {
    public static void main ( String[] args ) {
        // Create a new instance of LinkedQueueADT
        LinkedQueueADT<Integer> myQueue = new LinkedQueueADT<>();

        // Is the queue empty? : true
        System.out.println(myQueue.isEmpty());

        // What happens when we try to poll an empty queue?
        // It must throw an IllegalStateException in thread "main" java.lang.IllegalStateException: The queue is empty.
        // System.out.println(myQueue.poll()); // uncomment this line to see the exception

        // Add elements to the queue
        myQueue.offer( 10 );
        myQueue.offer( 20 );
        myQueue.offer( 30 );
        myQueue.offer( 40 );

        // Print the queue after adding elements
        System.out.println("Queue after adding elements: " + myQueue); // It must print [10, 20, 30, 40]

        // prints the element at the top of the queue
        System.out.println("The element at the top of queue: " + myQueue.peek()); // It must print 10
        // prints the element at the top of the queue
        System.out.println("The element at the top of queue: " + myQueue.peek()); // It must print 10
        // prints the element at the top of the queue
        System.out.println("The element at the top of queue: " + myQueue.peek()); // It must print 10

        // prints the element at the top of the queue and removes it
        System.out.println("The element at the top of queue: " + myQueue.poll()); // It must print 10
        // prints the element at the top of the queue and removes it
        System.out.println("The element at the top of queue: " + myQueue.poll()); // It must print 20

        // prints the number of elements in the queue
        System.out.println(myQueue.size()); // It must print 2

    }
}