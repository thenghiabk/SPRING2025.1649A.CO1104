package L04_Sorting;

public class BubbleSort {
    public static void sort( int[] array ) {
        for ( int i = 0; i < array.length; i++ ) {
            for ( int j = 1; j < array.length; j++ ) {
                if ( array[ j ] < array[ j - 1 ] ) {

                    // swap two elements
                    var temp = array[ j ];
                    array[ j ] = array[ j - 1 ];
                    array[ j - 1 ] = temp;
                }
            }
        }
    }
}

class BubbleSortRunner{
    public static void main ( String[] args ) {
        int[] numbers = {6, 10, 7, 5, 2,  4, 9, 8, 3};
        BubbleSort.sort( numbers );

        for (  int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[ i ] + " " );
        } // [2, 3, 4, 5, 6, 7, 8, 9, 10]
    }
}