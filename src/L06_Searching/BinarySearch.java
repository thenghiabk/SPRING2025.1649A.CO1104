package L06_Searching;

public class BinarySearch {
    public int binarySearchRec( int[] array, int target ) {
        return binarySearchRec( array, target, 0, array.length - 1 );
    }

    // recursive
    public int binarySearchRec( int[] array, int target, int left, int right ) {
        // base condition
        if ( right < left )
            return -1;

        int middle = ( left + right ) / 2;

        if ( array[ middle ] == target )
            return middle;

        if ( target < array[ middle ] )
            return binarySearchRec( array, target, left, middle - 1 );

        return binarySearchRec( array, target, middle + 1, right );
    }

    // iterative
    public int binarySearch( int[] array, int target ) {
        var left = 0;
        var right = array.length - 1;

        while ( left <= right ) {
            var middle = ( left + right ) / 2;

            if ( array[ middle ] == target )
                return middle;

            if ( target < array[ middle ] )
                right = middle - 1;
            else
                left = middle + 1;
        }

        return -1;
    }
}

class BinarySearchTest {
    public static void main( String[] args ) {
        int[] numbers = { 1, 3, 5, 6, 7 };
        var search = new BinarySearch( );
        var index = search.binarySearch( numbers, 7 );
        System.out.println( index );
    }
}
