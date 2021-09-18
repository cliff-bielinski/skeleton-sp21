package deque;

public class LinkedListDeque<Type> {

    /**Node object which contains a value and a pointer to the next Node object */
    public class Node<Type>{
        private Type value;
        private Node next;
        private Node previous;

        public Node(Type nodeValue, Node nextNode, Node previousNode){
            value = nodeValue;
            next = nextNode;
            previous = previousNode;
        }
    }

    private int size;
    private Node sentinel;

    /** Initializes Linked List Deque object*/
    public LinkedListDeque(){
        size = 0;
        sentinel = new Node<Type>(null, null, null);
    }

}
