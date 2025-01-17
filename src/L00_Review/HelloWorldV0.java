package L00_Review;

import java.util.Scanner;

public class HelloWorldV0 {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What's your name?: ");
        String name = scanner.nextLine();

        System.out.print("How old are you?: ");
        int age = Integer.parseInt( scanner.nextLine() );

        System.out.print("What's your email?: ");
        String email = scanner.nextLine();

        System.out.println("Hello " + name + "!");
        System.out.println("You are " + age + " years old.");
        System.out.println("Your email is " + email);

    }
}
