package L01_ArrayListADT;

import java.util.Arrays;

public class ArrayListADT<E> implements AbstractList<E> {

    // attributes
    private int[] elements; // stored in the stack memory
    int nextIndex;

    // constructor
    public ArrayListADT(){
        elements = new int[5];
        nextIndex = 0;
    }

    // methods

    @Override
    public boolean add ( int element ) {
        if (nextIndex == elements.length) {
            elements = Arrays.copyOf( elements, elements.length*2 );
        }

        elements[nextIndex] = element;
        nextIndex++;

        return true;
    }

    @Override
    public boolean add ( int index, int element ) {
        if (index < 0 || index >= nextIndex ){
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        if (nextIndex == elements.length) {
            elements = Arrays.copyOf( elements, elements.length*2 );
        }

        // shifts remaining elements to the right
        for (int i = nextIndex; i >= index; i--){
            elements[ i ] = elements[ i-1 ];
        }

        // insert new element
        elements[index] = element;
        nextIndex++;

        return true;
    }

    @Override
    public int get ( int index ) {
        if (index < 0 || index >= nextIndex ){
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        return elements[index];
    }

    @Override
    public int set ( int index, int element ) {
        if (index < 0 || index >= nextIndex ){
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        int oldElement = elements[index];

        elements[index] = element;
        return oldElement;
    }

    @Override
    public int remove ( int index ) {
        if (index < 0 || index >= nextIndex ){
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        int oldElement = elements[index];

        // shift remain elements to the left
        for(int i = index; i < nextIndex - 1; i++){
            elements[i] = elements[ i+1 ];
        }
        elements[nextIndex-1] = 0;
        nextIndex--;

        if (nextIndex < elements.length / 3){
            elements = Arrays.copyOf( elements, elements.length / 2 );
        }

        return oldElement;
    }

    @Override
    public int size () {
        return nextIndex;
    }

    @Override
    public int indexOf ( int element ) {
        for (int i = 0; i < nextIndex; i++){
            if (elements[i] == element){
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean contains ( int element ) {
        for (int item : elements){
            if (item == element){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty () {
        if (nextIndex == 0){
            return true;
        }
        return false;
    }
}

class ArrayListADTRunner{
    public static void main ( String[] args ) {
        ArrayListADT myArrayList = new ArrayListADT();
        myArrayList.add( 10 );
        myArrayList.add( 20 );
        myArrayList.add( 30 );
        myArrayList.add( 40 );
        myArrayList.add( 50 );

        myArrayList.add( 2, 60 );

        System.out.println(myArrayList.get(2));

        myArrayList.set(2, 80);

        System.out.println(myArrayList.get(2));

        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);

    }
}