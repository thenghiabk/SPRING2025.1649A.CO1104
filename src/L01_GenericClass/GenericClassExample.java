package L01_GenericClass;


class BoxInt {
    // data
    private int content;

    // constructor
    public BoxInt(int content) {
        this.content = content;
    }

    // methods
    public int getContent(){
        // add authentication validation
        return content;
    }
}

class BoxString {
    // data
    private String content;

    // constructor
    public BoxString(String content) {
        this.content = content;
    }

    // methods
    public String getContent(){
        // add authentication validation
        return content;
    }
}

class Box<E> {
    // data
    private E content;

    // constructor
    public Box(E content) {
        this.content = content;
    }

    // methods
    public E getContent(){
        return content;
    }
}

class Book{
    // data
    private String title;

    // constuctor
    public Book(String title){
        this.title = title;
    }

    // methods
    public String getTitle(){
        return title.toUpperCase();
    }
}

class Student {
    // data
    private String name;
    private int age;

    // constuctor
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    // methods
    public String getInfo(){
        return "Student: " + name + ", Age: " + age;
    }
}

public class GenericClassExample {
    public static void main ( String[] args ) {
        BoxInt b1 = new BoxInt( 10 );
        System.out.println(b1.getContent()); // 10

        BoxString b2 = new BoxString("hello");
        System.out.println(b2.getContent()); // "hello"

        Box<Integer> b3 = new Box<>( 20 );
        System.out.println(b3.getContent()); // 20

        Box<String> b4 = new Box<>( "world" );
        System.out.println(b4.getContent()); // "world"

        Box<Book> b5 = new Box<>(new Book("java programming for beginner"));
        Book book = b5.getContent();// return object Book
        System.out.println(book.getTitle()); // "JAVA PROGRAMMING FOR BEGINNER"

        Box<Student> b6 = new Box<>(new Student("John", 20));
        System.out.println(b6.getContent().getInfo()); // "Student: John, age: 20"
    }
}
