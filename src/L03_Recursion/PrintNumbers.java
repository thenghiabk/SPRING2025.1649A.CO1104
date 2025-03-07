package L03_Recursion;

public class PrintNumbers {
    public static void main( String[] args ) {
        printChainOfNums(5);
        System.out.println("Goodbye!");
    }

    static void printChainOfNums( int n ) {
        if(n == 0){ // base condition
            return;
        }

        printChainOfNums( n - 1 ); // recursive call
        System.out.println( n );
    }

    static void printReversedChainOfNums( int n ) {
        if ( n == 0 ) {
            return;
        }
        printReversedChainOfNums( n - 1 ); // recursive call
        System.out.print( n );
    }
}
