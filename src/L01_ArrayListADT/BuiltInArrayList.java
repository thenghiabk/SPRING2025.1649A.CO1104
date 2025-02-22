package L01_ArrayListADT;

import java.util.ArrayList;

public class BuiltInArrayList {
    public static void main ( String[] args ) {
        // create an ArrayList of Integers
        ArrayList<Integer> myIntArrayList = new ArrayList<>();

        // add elements to the ArrayList
        myIntArrayList.add( 10 );
        myIntArrayList.add( 20 );
        myIntArrayList.add( 30 );
        myIntArrayList.add( 40 );
        myIntArrayList.add( 50 );

        // print the ArrayList
        System.out.println( myIntArrayList );

        // add more elements
        myIntArrayList.add( 60 );
        myIntArrayList.add( 70 );
        myIntArrayList.add( 80 );

        // print the ArrayList again
        System.out.println( myIntArrayList );

        // remove an element
        myIntArrayList.remove( 5 );

        // print the ArrayList after removing an element
        System.out.println( myIntArrayList );

        // print the size of the ArrayList
        System.out.println( myIntArrayList.size() );

        // check if the ArrayList is empty
        System.out.println( myIntArrayList.isEmpty() );

    }
}
