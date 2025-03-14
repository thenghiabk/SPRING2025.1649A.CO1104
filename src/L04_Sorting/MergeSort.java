package L04_Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void sort ( int[] array ) {
        // base condition
        if ( array.length < 2 ) { // array has a single item or no item
            return;
        }

        // Divide this array into half
        var middle = array.length / 2;

        int[] left = new int[ middle ];
        for ( int i = 0; i < middle; i++ ) {
            left[ i ] = array[ i ];
        }

        int[] right = new int[ array.length - middle ];
        for ( int i = middle; i < array.length; i++ ) {
            right[ i - middle ] = array[ i ];
        }

        // Sort each half
        sort( left );
        sort( right );

        // Merge the result
        merge( left, right, array );
    }

    private static void merge ( int[] left, int[] right, int[] result ) {
        int i = 0, j = 0, k = 0;
        while ( i < left.length && j < right.length ) {
            if ( left[ i ] <= right[ j ] ) {
                result[ k++ ] = left[ i++ ];
            } else {
                result[ k++ ] = right[ j++ ];
            }
        }

        // copy remaining source array to the end of destination array
        while ( i < left.length )
            result[ k++ ] = left[ i++ ];

        while ( j < right.length )
            result[ k++ ] = right[ j++ ];
    }
}

class MergeSortTest {
    public static void main ( String[] args ) {
        int[] numbers = {6, 10, 7, 5, 2,  4, 9, 8, 3};
        MergeSort.sort( numbers );

        for (  int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[ i ] + " " );
        } // [2, 3, 4, 5, 6, 7, 8, 9, 10]
    }
}