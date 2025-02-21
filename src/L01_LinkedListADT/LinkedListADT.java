package L01_LinkedListADT;

public class LinkedListADT<E> implements AbtractLinkedList<E> {
    // The head of the linked list
    private Node head;
    // The tail of the linked list
    private Node tail;
    // The number of elements in the linked list
    private int size;

    // constructor
    public LinkedListADT(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an element to the beginning of the collection and increases the size.
     * If the collection is empty, the new element becomes the head and tail.
     * @param element the element to be added
     */
    @Override
    public void addFirst ( E element ) {
        // Create a new node with the given element
        Node newNode = new Node( element );

        // If the list is empty, set the head and tail to the new node
        if (this.head == null && this.tail == null){
            this.head = newNode;
            this.tail = newNode;
        } else { // if list is not empty
            // Set the next reference of the new node to the current head
            newNode.next = this.head;
            // Update the head reference to the new node
            this.head = newNode;
        }

        // Increment the size of the list
        this.size++;
    }

    /**
     * Adds an element to the end of the collection and increases the size.
     * If the collection is empty, the new element becomes the head and tail.
     * @param element the element to be added
     */
    @Override
    public void addLast ( E element ) {
        // Create a new node with the given element
        Node newNode = new Node( element );

        // If the list is empty, set the head and tail to the new node
        if (this.head == null && this.tail == null){
            this.head = newNode;
            this.tail = newNode;
        } else { // if list is not empty
            // Set the next reference of the tail to the new node
            this.tail.next = newNode;
            // Update the tail reference to the new node
            this.tail = newNode;
        }

        // Increment the size of the list
        this.size++;
    }

    /**
     * Removes and returns the first element of the collection.
     * Throws an IllegalStateException if the collection is empty.
     *
     * @return the removed first element
     * @throws IllegalStateException if the collection is empty
     */
    @Override
    public E removeFirst () {

        // if list is empty
        if (this.head == null && this.tail == null){
            // throw exception
            throw new IllegalStateException("The list is empty.");
        }

        // store the element to be removed
        E oldElement = this.head.element;

        // if list has only one element
        if (this.head == this.tail){
            // set head and tail to null
            this.head = null;
            this.tail = null;
        } else { // if list has more than one element
            // store the current head
            Node tempNode = this.head;
            // set the head to the next element
            this.head = this.head.next;
            // set the next reference of the current head to null
            tempNode.next = null;
        }

        // decrement the size of the list
        this.size--;

        // return the removed element
        return oldElement;
    }

    /**
     * Removes and returns the last element of the collection.
     * Throws an IllegalStateException if the collection is empty.
     *
     * @return the removed last element
     * @throws IllegalStateException if the collection is empty
     */
    @Override
    public E removeLast() {
        // Check if the list is empty
        if (this.head == null && this.tail == null) {
            throw new IllegalStateException("The list is empty.");
        }

        // Store the element to be removed
        E oldElement = this.tail.element;

        // If the list has only one element
        if (this.head == this.tail) {
            // Set head and tail to null
            this.head = null;
            this.tail = null;
        } else {
            // Traverse the list to find the second-to-last node
            Node tempNode = this.head;
            while (tempNode.next != this.tail) {
                tempNode = tempNode.next;
            }

            // Update the tail to the second-to-last node
            tempNode.next = null;
            this.tail = tempNode;
        }

        // Decrement the size of the list
        this.size--;

        // Return the removed element
        return oldElement;
    }

    @Override
    /**
     * Returns the first element of the collection without removing it.
     * Throws an IllegalStateException if the collection is empty.
     *
     * @return the first element
     * @throws IllegalStateException if the collection is empty
     */
    public E getFirst () {
        if (this.head == null && this.tail == null){
            throw new IllegalStateException("The list is empty.");
        }
        return this.head.element;
    }

    @Override
    /**
     * Returns the last element of the collection without removing it.
     * Throws an IllegalStateException if the collection is empty.
     *
     * @return the last element
     * @throws IllegalStateException if the collection is empty
     */
    public E getLast () {
        if (this.head == null && this.tail == null){
            throw new IllegalStateException("The list is empty.");
        }
        return this.tail.element;
    }

    @Override
    public int size () {
        return this.size;
    }

    @Override
    public boolean isEmpty () {
        return (this.head == null && this.tail == null);
    }

    /**
     * Converts the linked list to a string representation.
     * The string will be in the format [element1, element2, ... , elementN]
     * where element1 is the first element and elementN is the last element.
     * @return a string representation of the linked list
     */
    @Override
    public String toString() {
        // Create a StringBuilder to build the string representation of the list
        StringBuilder result = new StringBuilder();
        result.append("[");

        // Traverse the list from head to tail
        Node tempNode = this.head;
        while (tempNode != null) {
            // Append the element of the current node
            result.append(tempNode.element);
            // Append a comma if there is a next node
            if (tempNode.next != null) {
                result.append(", ");
            }
            // Move to the next node
            tempNode = tempNode.next;
        }

        // Close the string representation with a closing bracket
        result.append("]");
        return result.toString();
    }

    /**
     * Private inner class to represent a node in the linked list.
     */
    private class Node {
        // data
        private E element; // the actual element stored in the node
        private Node next; // the next node in the list

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

        // Add elements to the list in the forward order
        myLinkedList.addFirst( 10 );
        myLinkedList.addFirst( 20 );
        myLinkedList.addFirst( 30 );
        myLinkedList.addFirst( 40 );

        // Add elements to the list in the backward order
        myLinkedList.addLast( 50 );
        myLinkedList.addLast( 60 );

        // Remove the first element
        System.out.println(myLinkedList.removeFirst()); // 40

        // Check if the list is empty
        System.out.println(myLinkedList.isEmpty()); // false

        // Get the first element
        System.out.println(myLinkedList.getFirst()); // 30

        // Remove the last element
        System.out.println(myLinkedList.removeLast()); // 60

        // Get the last element
        System.out.println(myLinkedList.getLast()); // 50

        // Print the list
        System.out.println(myLinkedList);

    }
}