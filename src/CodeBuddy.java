public class CodeBuddy {
    public static void main(String[] args) {
        sayHello();
    }

    private static void sayHello(){
        System.out.println("Hello");

        sayHello();
    }

}