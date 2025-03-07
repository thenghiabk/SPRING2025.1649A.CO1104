package L03_Recursion;

public class NumberReversing {
    public static void main( String[] args ) {
        reverse( 123456789 );
    }

    static void reverse( int n ) {
        if ( n == 0 ) {
            return;
        }
        int lastDigit = n % 10;
        int remainder = n / 10;
        System.out.println( lastDigit );
        reverse( remainder );
    }
}
