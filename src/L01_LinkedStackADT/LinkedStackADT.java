package L01_LinkedStackADT;

/**
 * This class implements the AbstractLinkedStack interface to create a
 * linked list based stack data structure. The stack is a Last In First Out (LIFO)
 * data structure, meaning the last element added is the first one to be removed.
 * The class provides methods to add and remove elements from the stack, as well as
 * to check the size and emptiness of the stack.
 */

public class LinkedStackADT<E> implements AbstractLinkedStack<E> {
    // reference to the top node of the stack
    private Node top;
    // number of elements in the stack
    private int size;

    // constructor
    public LinkedStackADT(){
        this.top = null;
        this.size = 0;
    }

    /**
     * Adds an element to the top of the stack and increases the size.
     * The added element becomes the new top of the stack.
     * @param element the element to be added
     */
    @Override
    public void push(E element) {
        // Create a new node with the given element
        Node newNode = new Node(element);
        // Set the next reference of the new node to the current top node
        newNode.next = this.top;
        // Update the top reference to the new node
        this.top = newNode;
        // Increment the size of the stack
        this.size++;
    }

    /**
     * Removes and returns the top element from the stack.
     * If the stack is empty, throws an IllegalStateException.
     * @return the element that was removed from the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E pop () {
        // Check if the stack is empty and throw an exception if true
        if (this.top == null) {
            throw new IllegalStateException("The stack is empty.");
        }

        // Store the element from the top node
        E oldElement = this.top.element;

        // Update the top to the next node
        this.top = this.top.next;

        // Decrement the size of the stack
        this.size--;

        // Return the removed element
        return oldElement;
    }

    /**
     * Returns the top element from the stack without removing it.
     * If the stack is empty, throws an IllegalStateException.
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E peek () {
        if (this.top == null) {
            throw new IllegalStateException("The stack is empty.");
        }
        return this.top.element;
    }

    @Override
    public int size () {
        return this.size;
    }

    @Override
    public boolean isEmpty () {
        return (this.top == null);
    }

    /**
     * This method returns a string representation of the stack.
     * The string will be in the format [element1, element2, ... , elementN]
     * where element1 is the top element and elementN is the bottom element.
     * @return a string representation of the stack
     */
    @Override
    public String toString () {
        StringBuilder result = new StringBuilder();
        result.append( "[" );

        // iterate through the nodes in the stack
        Node tempNode = this.top;
        while(tempNode != null){
            result.append( tempNode.element );
            if(tempNode.next != null){
                result.append( ", " );
            }

            // move to the next node
            tempNode = tempNode.next;
        }

        result.append( "]" );

        return result.toString();
    }

    /**
     * Node class for use in the LinkedStackADT.
     * <p>
     * This class represents a node in the linked list.
     * It contains a reference to the element being stored and a reference to the next node in the list.
     */
    private class Node {
        // data
        private E element; // the actual element stored in the node
        private Node next; // the next node in the stack

        // constructor
        public Node ( E element ) {
            this.element = element;
            this.next = null;
        }
    }
}

class LinkedStackADTRunner {
    public static void main ( String[] args ) {
        // Create a new instance of LinkedStackADT
        LinkedStackADT<Integer> myStack = new LinkedStackADT<>();

        // print out whether the stack is empty or not
        System.out.println("Is the stack empty? : " + myStack.isEmpty()); // true

        // What happens when we try to poll an empty queue?
        // It must throw an IllegalStateException in thread "main" java.lang.IllegalStateException: The queue is empty.
        //System.out.println(myStack.pop()); // uncomment this line to see the exception

        // add four elements to the stack
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);

        // Pop and print the top element, should be 40
        System.out.println("The element at top of stack : " + myStack.pop()); // 40

        // Check if the stack is empty, should be false
        System.out.println("Is the stack empty? : " + myStack.isEmpty()); // false

        // Print the size of the stack, should be 3
        System.out.println("Size of the current stack? : " + myStack.size()); // 3

        // Pop the next element, which is 30
        myStack.pop(); // remove the 30

        // Peek and print the top element, should be 20
        System.out.println("The element at top of stack : " + myStack.peek()); // 20
        System.out.println("The element at top of stack : " + myStack.peek()); // 20
        System.out.println("The element at top of stack : " + myStack.peek()); // 20

        // Pop and print the remaining elements
        System.out.println(myStack.pop()); // 20
        System.out.println(myStack.pop()); // 10


        //System.out.println(myStack.pop()); // uncomment the following line to see the exception
     }
}