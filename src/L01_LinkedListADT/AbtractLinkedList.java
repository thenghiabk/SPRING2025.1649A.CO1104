package L01_LinkedListADT;

public interface AbtractLinkedList<E> {
    void addFirst(E element); // adds an element in front of the collection and increases the size.
    void addLast(E element); // adds an element after the last element of the collection and increases the size.
    E removeFirst (); // removes and returns the first element of the collection if there is such if no then throw
    // IllegalStateException with appropriate message.
    E removeLast (); // removes and returns the last element of the collection if there is such if no then throw
    // IllegalStateException with appropriate message.
    E getFirst (); // returns the first element of the collection if there is such if no then throw
    // IllegalStateException with appropriate message.
    E getLast (); // returns the last element of the collection if there is such if no then throw
    // IllegalStateException with appropriate message.
    int size(); // returns the number of elements in the collection
    boolean isEmpty(); // returns true if the collection is empty
}
