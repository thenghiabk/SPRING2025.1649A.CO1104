package L00_Review;

public class HelloWorldV1 {
    public static void main ( String[] args ) {
        int x = 5;
        int result = myMethod( x );

        System.out.println(result); // ? (a) 15
        System.out.println(x); // ? (b) 5

    }

    static int myMethod(int x) {
        x = 10;
        return 5 + x;
    }

}
