package L06_Searching;

public class LinearSearch {
    public int linearSearch( int[] array, int target ) {
        for ( var i = 0; i < array.length; i++ ) {
            if ( array[ i ] == target ) {
                return i;
            }
        }
        return -1;
    }
}

class LinearSearchTest {
    public static void main( String[] args ) {
        int[] numbers = { 7, 1, 3, 6, 5 };
        var search = new LinearSearch( );
        var index = search.linearSearch( numbers, 6 );
        System.out.println( index );
    }

}