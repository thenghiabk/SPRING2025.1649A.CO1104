package L01_LinkedStackADT;

public interface AbstractLinkedStack<E> {
    void push(E element); // adds an element at the top of the stack and increases the size.
    E pop(); // removes the top element from the stack and decreases the size.
    E peek(); // returns the top element from the stack without removing it.
    int size(); // returns the number of elements in the stack
    boolean isEmpty(); // returns true if the stack is empty
}
