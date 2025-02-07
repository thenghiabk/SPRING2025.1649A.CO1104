package L01_ArrayListADT;

import java.util.ArrayList;

public class BuiltInArrayList {
    public static void main ( String[] args ) {
        ArrayList<Integer> myIntArrayList = new ArrayList<>();
        myIntArrayList.add( 10 );
        myIntArrayList.add( 20 );
        myIntArrayList.add( 30 );
        myIntArrayList.add( 40 );
        myIntArrayList.add( 50 );

        System.out.println( myIntArrayList );

        myIntArrayList.add( 60 );
        myIntArrayList.add( 70 );
        myIntArrayList.add( 80 );

        System.out.println( myIntArrayList );

        myIntArrayList.remove( 5 );

        System.out.println( myIntArrayList );

        System.out.println( myIntArrayList.size() );

        System.out.println( myIntArrayList.isEmpty() );

    }
}
