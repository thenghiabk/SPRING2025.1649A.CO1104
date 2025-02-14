package L01_Node;

public class Node {
    // data
    public int element;
    public Node next;

    // constructor
    public Node(int element){
        this.element = element;
        this.next = null;
    }
}

class NodeRunner {
    public static void main ( String[] args ) {
        Node n0 = new Node(10);
        Node n1 = new Node(20);
        Node n2 = new Node(30);

        // connect nodes
        n0.next = n1;
        n1.next = n2;

        System.out.println(n0.element); // 10
        System.out.println(n1.element); // 20
        System.out.println(n2.element); // 30

        // prints n2 through n0
        System.out.println(n0.next.next.element); // ~ n2.element
    }
}