
**Section 1: Class Declaration and Fields**

```java
public class LinkedListADT<E> implements AbtractLinkedList<E> {
    // The head of the linked list
    private Node head;
    // The tail of the linked list
    private Node tail;
    // The number of elements in the linked list
    private int size;
```

This section declares the `LinkedListADT` class, which implements the `AbtractLinkedList` interface. The class has three private fields: `head`, `tail`, and `size`. The `head` and `tail` fields represent the first and last nodes in the linked list, respectively. The `size` field keeps track of the number of elements in the list.

**Section 2: Constructor**

```java
// constructor
public LinkedListADT(){
    this.head = null;
    this.tail = null;
    this.size = 0;
}
```

This section defines the constructor for the `LinkedListADT` class. The constructor initializes the `head`, `tail`, and `size` fields to their default values: `null`, `null`, and `0`, respectively.

**Section 3: Adding Elements**

```java
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
```

This section defines two methods for adding elements to the linked list: `addFirst` and `addLast`. The `addFirst` method adds an element to the beginning of the list, while the `addLast` method adds an element to the end of the list. Both methods create a new node with the given element and update the `head` and `tail` references accordingly.


**Section 4: Removing Elements (continued)**

```java
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
```

This section defines two methods for removing elements from the linked list: `removeFirst` and `removeLast`. The `removeFirst` method removes the first element from the list, while the `removeLast` method removes the last element from the list. Both methods update the `head` and `tail` references accordingly and decrement the `size` field.

**Section 5: Accessing Elements**

```java
/**
 * Returns the first element of the collection without removing it.
 * Throws an IllegalStateException if the collection is empty.
 *
 * @return the first element
 * @throws IllegalStateException if the collection is empty
 */
@Override
public E getFirst () {
    if (this.head == null && this.tail == null){
        throw new IllegalStateException("The list is empty.");
    }
    return this.head.element;
}

/**
 * Returns the last element of the collection without removing it.
 * Throws an IllegalStateException if the collection is empty.
 *
 * @return the last element
 * @throws IllegalStateException if the collection is empty
 */
@Override
public E getLast () {
    if (this.head == null && this.tail == null){
        throw new IllegalStateException("The list is empty.");
    }
    return this.tail.element;
}
```

This section defines two methods for accessing elements in the linked list: `getFirst` and `getLast`. The `getFirst` method returns the first element in the list, while the `getLast` method returns the last element in the list. Both methods throw an `IllegalStateException` if the list is empty.

**Section 6: Miscellaneous Methods**

```java
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
```

This section defines several miscellaneous methods for the linked list, including `size`, `isEmpty`, and `toString`. The `size` method returns the number of elements in the list, while the `isEmpty` method checks if the list is empty. The `toString` method returns a string representation of the linked list.



**Section 7: Node Class**

```java
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
```

This section defines a private inner class `Node` to represent a node in the linked list. Each node has two fields: `element` to store the actual element, and `next` to point to the next node in the list. The `Node` class has a constructor to initialize the `element` field and set the `next` field to `null`.

