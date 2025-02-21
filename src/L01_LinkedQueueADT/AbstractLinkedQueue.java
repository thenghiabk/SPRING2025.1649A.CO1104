package L01_LinkedQueueADT;

public interface AbstractLinkedQueue<E> {
    void offer(E element); // adds an element at the end of the queue and increases the size.
    E poll(); // removes and returns the first element at the queue also decreases the size
    E peek(); // return the element at the current front of the queue
    int size(); // returns the number of elements inside the stack
    boolean isEmpty(); // returns if the stack contains any elements or not.
}
