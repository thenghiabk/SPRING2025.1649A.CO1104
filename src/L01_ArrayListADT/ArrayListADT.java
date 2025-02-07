package L01_ArrayListADT;

import java.util.Arrays;

public class ArrayListADT implements AbstractList {

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
        return 0;
    }

    @Override
    public int set ( int index, int element ) {
        return 0;
    }

    @Override
    public int remove ( int index ) {
        return 0;
    }

    @Override
    public int size () {
        return 0;
    }

    @Override
    public int indexOf ( int element ) {
        return 0;
    }

    @Override
    public boolean contains ( int element ) {
        return false;
    }

    @Override
    public boolean isEmpty () {
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

    }
}