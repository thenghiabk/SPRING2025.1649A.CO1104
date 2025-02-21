package L01_LinkedStackADT;

public class LinkedStackADT<E> implements AbstractLinkedStack<E> {
    private Node top;
    private int size;

    // constructor
    public LinkedStackADT(){
        this.top = null;
        this.size = 0;
    }
    @Override
    public void push ( E element ) {
        Node newNode = new Node( element );

        // if stack is empty
        if (this.top == null){
            this.top = newNode;
        } else { // if stack is not empty
            newNode.next = this.top;
            this.top = newNode;
        }

        this.size++;
    }

    @Override
    public E pop () {
        // if stack is empty
        if (this.top == null){
            throw new IllegalStateException("The stack is empty.");
        }

        // if stack is not empty
        E oldElement = this.top.element;

        Node tempNode = this.top;
        this.top = this.top.next;
        tempNode.next = null;

        this.size--;

        return oldElement;
    }

    @Override
    public E peek () {
        // if stack is empty
        if (this.top == null){
            throw new IllegalStateException("The stack is empty.");
        }

        return this.top.element;
    }

    @Override
    public int size () {
        return this.size;
    }

    @Override
    public boolean isEmpty () {
        return (this.top == null);
    }

    private class Node {
        // data
        private E element;
        private Node next;

        // constructor
        public Node ( E element ) {
            this.element = element;
            this.next = null;
        }
    }
}

class LinkedStackADTRunner {
    public static void main ( String[] args ) {
        LinkedStackADT<Integer> myStack = new LinkedStackADT<>();
        System.out.println("Is the stack empty? : " + myStack.isEmpty()); // true
        //System.out.println(myStack.pop()); // Exception in thread "main" java.lang.IllegalStateException: The stack is empty.
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);

        System.out.println("The element at top of stack : " + myStack.pop()); // 40
        System.out.println("Is the stack empty? : " + myStack.isEmpty()); // false
        System.out.println("Size of the current stack? : " + myStack.size()); // 3

        myStack.pop(); // ?
        myStack.peek(); // ?
        myStack.peek(); // ?
        myStack.peek(); // ?
        System.out.println(myStack.pop()); // 20
        System.out.println(myStack.pop()); // 10
        System.out.println(myStack.pop()); // Exception in thread "main" java.lang.IllegalStateException: The stack is empty.
     }
}