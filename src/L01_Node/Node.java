package L01_Node;

/**
 * A simple Node class for a linked list.
 */
public class Node {
    /**
     * The data element of the node
     */
    public int element;
    /**
     * The reference to the next node in the list
     */
    public Node next;

    /**
     * Constructor to initialize the node with the given element.
     * Sets the next reference to null.
     * @param element the element to be stored in the node
     */
    public Node(int element){
        this.element = element;
        this.next = null;
    }
}

class NodeRunner {
    public static void main ( String[] args ) {
        Node n0 = new Node(10); // Create node with element 10
        Node n1 = new Node(20); // Create node with element 20
        Node n2 = new Node(30); // Create node with element 30

        // Connect nodes in sequence: n0 -> n1 -> n2
        n0.next = n1;
        n1.next = n2;

        // Print elements of each node
        System.out.println(n0.element); // Output: 10
        System.out.println(n1.element); // Output: 20
        System.out.println(n2.element); // Output: 30

        // Access and print n2's element through n0's next references
        System.out.println(n0.next.next.element); // Output: 30
    }
}