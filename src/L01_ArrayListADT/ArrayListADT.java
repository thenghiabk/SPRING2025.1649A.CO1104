package L01_ArrayListADT;

public class ArrayListADT implements AbstractList {

    // attributes
    private int[] elements; // stored in the stack memory

    // constructor
    public ArrayListADT(){
        elements = new int[5];
    }

    // methods

    @Override
    public boolean add ( int element ) {



        return true;
    }

    @Override
    public boolean add ( int index, int element ) {
        return false;
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
