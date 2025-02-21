package L01_LinkedQueueADT;

/**
 * Why do we need an interface?
 *
 * An interface is a contract. It sets a standard for classes that implements it.
 * It provides a way to define a blueprint of methods, without having to write the
 * implementation of them. This allows for classes to be more flexible and
 * reusable. And, it makes the code more readable and maintainable.
 *
 * In this case, AbstractLinkedQueue is an interface that defines the contract for
 * a linked queue data structure. It provides the methods that must be implemented
 * by any class that implements it. This allows for different classes to implement
 * the queue data structure in their own way, but ensure that they provide the same
 * functionality and behavior.
 *
 * For example, one class may implement the queue using a linked list, while
 * another class may implement it using an array. As long as they implement the
 * AbstractLinkedQueue interface, they will both provide the same methods and
 * behavior, even though they may be implemented differently.
 */
public interface AbstractLinkedQueue<E> {
    /**
     * Adds an element at the end of the queue and increases the size.
     * If the queue is empty, the new element becomes the head and tail.
     * @param element the element to be added
     */
    void offer(E element);
    /**
     * Removes and returns the first element from the queue.
     * If the queue is empty, throws an IllegalStateException.
     * @return the element that was removed from the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    E poll();
    /**
     * Returns the first element in the queue without removing it.
     * If the queue is empty, throws an IllegalStateException.
     *
     * @return the first element in the queue
     * @throws IllegalStateException if the queue is empty
     */
    E peek();
    /**
     * Returns the number of elements in the stack
     * @return the number of elements in the stack
     */
    int size();
    /**
     * Returns if the stack contains any elements or not.
     * @return if the stack contains any elements or not.
     */
    boolean isEmpty();
}
