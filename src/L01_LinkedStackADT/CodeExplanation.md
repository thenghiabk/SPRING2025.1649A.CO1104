
**Section 1: Class Definition and Constructor**
```java
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
```
This section defines the `LinkedStackADT` class, which implements the `AbstractLinkedStack` interface. The class has two instance variables: `top`, which references the top node of the stack, and `size`, which keeps track of the number of elements in the stack. The constructor initializes the `top` node to `null` and sets the `size` to 0.

**Section 2: Node Class**
```java
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
```
This section defines a private inner class called `Node`, which represents a node in the linked list. Each node has two instance variables: `element`, which stores the actual element, and `next`, which references the next node in the stack. The constructor initializes the `element` and sets the `next` node to `null`.

**Section 3: Push Method**
```java
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
```
This section defines the `push` method, which adds a new element to the top of the stack. It creates a new `Node` object with the given element, sets the `next` reference of the new node to the current `top` node, updates the `top` reference to the new node, and increments the `size` of the stack.

**Section 4: Pop Method**
```java
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
```
This section defines the `pop` method, which removes and returns the top element from the stack. It checks if the stack is empty and throws an exception if true. Otherwise, it stores the element from the top node, updates the `top` reference to the next node, decrements the `size` of the stack, and returns the removed element.

**Section 5: Peek Method**
```java
@Override
public E peek () {
    if (this.top == null) {
        throw new IllegalStateException("The stack is empty.");
    }
    return this.top.element;
}
```
This section defines the `peek` method, which returns the top element from the stack without removing it. It checks if the stack is empty and throws an exception if true. Otherwise, it returns the element from the top node.

**Section 6: Size and isEmpty Methods**
```java
@Override
public int size () {
    return this.size;
}

@Override
public boolean isEmpty () {
    return (this.top == null);
}
```
This section defines the `size` and `isEmpty` methods, which return the number of elements in the stack and whether the stack is empty, respectively.

**Section 7: toString Method**
```java
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
```
This section defines the `toString` method, which returns a string representation of the stack. It iterates through the nodes in the stack and appends each element to a `StringBuilder`, separated by commas.



**Section 8: Test Driver**
```java
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
```
This section defines a test driver class called `LinkedStackADTRunner`, which creates an instance of the `LinkedStackADT` class and tests its methods. The test driver adds elements to the stack, pops elements from the stack, checks the stack's emptiness and size, and peeks at the top element.

The test driver demonstrates the correct behavior of the `LinkedStackADT` class, including:

* Creating an empty stack and checking its emptiness
* Adding elements to the stack and checking its size
* Popping elements from the stack and checking the top element
* Peeking at the top element without removing it
* Removing all elements from the stack and checking its emptiness again

Overall, the `LinkedStackADT` class provides a basic implementation of a linked stack data structure, and the test driver demonstrates its correct behavior.