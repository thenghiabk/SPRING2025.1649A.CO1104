package L01_ArrayListADT;

import java.util.Arrays;

public class ArrayListADT<E> implements AbstractList<E> {

    // Attributes
    private static final int DEFAULT_CAPACITY = 5; // Default initial capacity
    private E[] elements; // Array to store the elements
    int nextIndex; // Index of the next available position.
    // nextIndex is also used to keep track of the number of elements in the array.

    // Constructor
    public ArrayListADT() {
        elements = (E[]) new Object[DEFAULT_CAPACITY]; // Initialize array with default capacity
        nextIndex = 0; // Initialize nextIndex to 0
    }

    // methods

    /**
     * Adds the specified element at the end of the list and increases the size.
     * If the array is full, it doubles the array size.
     * @param element the element to be added
     * @return true if the element was added successfully, false otherwise
     */
    @Override
    public boolean add ( E element ) {
        // If the array is full, double the array size
        if (nextIndex == elements.length) {
            elements = Arrays.copyOf( elements, elements.length*2 );
        }

        // Store the element at the next available position
        elements[nextIndex] = element;

        // Increment the nextIndex
        nextIndex++;

        // Return true to indicate that the element was added successfully
        return true;
    }

    /**
     * Inserts the specified element at the specified position in the list.
     * If the index is out of bounds, it throws an IndexOutOfBoundsException.
     * If the array is full, it doubles the array size.
     * @param index the position of the element to be inserted
     * @param element the element to be inserted
     * @return true if the element was added successfully, false otherwise
     */
    @Override
    public boolean add ( int index, E element ) {
        // Check if the index is valid
        if (index < 0 || index >= nextIndex ){
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        // If the array is full, double the array size
        if (nextIndex == elements.length) {
            elements = Arrays.copyOf( elements, elements.length*2 );
        }

        // Shift the elements to the right
        for (int i = nextIndex; i >= index; i--){
            elements[ i ] = elements[ i-1 ];
        }

        // Insert the new element at the specified index
        elements[index] = element;

        // Increment the nextIndex
        nextIndex++;

        // Return true to indicate that the element was added successfully
        return true;
    }

    /**
     * Returns the element at the specified position in the list.
     * @param index the position of the element to be returned
     * @return the element at the specified position
     */
    @Override
    public E get ( int index ) {
        // Check if the index is within valid range
        if (index < 0 || index >= nextIndex ){
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        // Return the element at the specified index
        return elements[index];
    }

    /**
     * Replaces the element at the specified position in the list with the
     * specified element.
     * @param index the position of the element to be replaced
     * @param element the element to be added
     * @return the element that was replaced
     */
    @Override
    public E set ( int index, E element ) {
        // Check if the index is valid
        if (index < 0 || index >= nextIndex ){
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        // Store the old element
        E oldElement = elements[index];

        // Replace the element at the specified index with the new element
        elements[index] = element;

        // Return the old element
        return oldElement;
    }

    /**
     * Removes the element at the specified position in the list and shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    @Override
    public E remove ( int index ) {
        // Check if the index is valid
        if (index < 0 || index >= nextIndex ){
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        // Store the old element
        E oldElement = elements[index];

        // Shift the remaining elements to the left
        for(int i = index; i < nextIndex - 1; i++){
            elements[i] = elements[ i+1 ];
        }

        // Set the last element to null and decrement the size
        elements[nextIndex-1] = null;
        nextIndex--;

        // If the array is one third empty, shrink it by half its size
        if (nextIndex < elements.length / 3){
            elements = Arrays.copyOf( elements, elements.length / 2 );
        }

        // Return the removed element
        return oldElement;
    }

    @Override
    public int size () {
        return nextIndex;
    }

    @Override
    public int indexOf ( E element ) {
        // loop through the array to find the element
        for (int i = 0; i < nextIndex; i++){
            // if the element is found, return its index
            if (elements[i] == element){
                return i;
            }
        }

        // if the element is not found, return -1
        return -1;
    }

    /**
     * Checks if the list contains the specified element.
     * @param element the element to be searched
     * @return true if the list contains the element, false otherwise
     */
    @Override
    public boolean contains ( E element ) {
        // loop through the array to find the element
        for (var item : elements){
            // if the element is found, return true
            if (item == element){
                return true;
            }
        }

        // if the element is not found, return false
        return false;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty () {
        // if the size of the list is 0, return true
        if (nextIndex == 0){
            return true;
        }
        // otherwise, return false
        return false;
    }

    @Override
    public String toString () {
        // Convert the array list to a string, for example, elements -> [10, 20, 30, 40, 50]

        // Option 1
        //String result = "[";
        //
        //for (int i = 0; i < nextIndex; i++){
        //    result += elements[i];
        //
        //    if (i < nextIndex - 1){
        //        result += ", ";
        //    }
        //}
        //
        //result += "]";

        // Option 2
        // Create a StringBuilder to construct the string representation
        StringBuilder result = new StringBuilder();

        // Start with an opening bracket
        result.append("[");

        // Iterate through the elements array
        for (int i = 0; i < nextIndex; i++) {
            // Append the current element to the result
            result.append(elements[i]);

            // If it's not the last element, append a comma and space
            if (i < nextIndex - 1) {
                result.append(", ");
            }
        }

        // End with a closing bracket
        result.append("]");

        // Convert StringBuilder to String and return
        return result.toString();
    }
}

class ArrayListADTRunner{
    public static void main ( String[] args ) {
        ArrayListADT<Integer> myArrayList = new ArrayListADT<>();

        // Add elements to the list
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);

        // Add an element at index 2
        myArrayList.add(2, 60); // List becomes [10, 20, 60, 30, 40, 50]

        // Retrieve and print the element at index 2
        System.out.println(myArrayList.get(2)); // Output: 60

        // Set a new value at index 2
        myArrayList.set(2, 80); // List becomes [10, 20, 80, 30, 40, 50]
        myArrayList.set(2, 80); // [10, 20, 80, 30, 40, 50]

        System.out.println(myArrayList.get(2)); // 80

        myArrayList.remove(0);

        System.out.println( myArrayList ); // [20, 80, 30, 40, 50]

        //ArrayListADT<String> myStringArrayList = new ArrayListADT<>();
        //myStringArrayList.add("Hello");
        //myStringArrayList.add("World");
        //
        //// Retrieves the element at index 0
        //System.out.println(myStringArrayList.get(0)); // Hello
        //// Retrieves the element at index 1
        //System.out.println(myStringArrayList.get(1)); // World
        //
        //// Returns the index of the first occurrence of the specified element
        //System.out.println(myStringArrayList.indexOf( "World" )); // 1
        //// Returns true if the list contains the specified element
        //System.out.println(myStringArrayList.contains( "World" )); // true

    }
}