package deque;

public class LinkedListDeque<T> {

    /**Node object which contains a value and a pointer to the next Node object */
    public class Node{
        private T value;
        private Node next;
        private Node previous;

        /** Initializes Node object of Type value and points to previous and next Node */
        public Node(T nodeValue, Node nextNode, Node previousNode){
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
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
    }

    /** returns the size of the list */
    public int size(){
        return size;
    }

    /** returns true if the list is empty*/
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    /** adds a new Node to the list in the first position */
    public void addFirst(T item){
        Node oldFirst = sentinel.next;
        Node newNode = new Node(item, oldFirst, sentinel);
        sentinel.next = newNode;
        oldFirst.previous = newNode;
        size += 1;
    }

    /** adds a new Node to the list in the last position*/
    public void addLast(T item){
        Node oldLast = sentinel.previous;
        Node newNode = new Node(item, sentinel, oldLast);
        sentinel.previous = newNode;
        oldLast.next = newNode;
        size += 1;
    }

    /** prints the values of the Nodes currently in the list */
    public void printDeque(){
        Node current = sentinel.next;
        while (current != sentinel){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    /** removes the first Node and returns it */
    public T removeFirst(){
        Node first = sentinel.next;
        if (first == sentinel){
            return null;
        }
        sentinel.next = first.next;
        first.next.previous = sentinel;
        size -= 1;
        return first.value;
    }

    /** removes the last Node and returns it */
    public T removeLast(){
        Node last = sentinel.previous;
        if (last == sentinel){
            return null;
        }
        sentinel.previous = last.previous;
        last.previous.next = sentinel;
        size -= 1;
        return last.value;
    }

    /** returns the value of Node at given index using iteration*/
    public T get(int index){
        if (index >= size){
            return null;
        }
        Node current = sentinel.next;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.value;
    }

    /** returns the value of Node at a given index using recursion */
    public T getRecursive(int index){
        if (index >= size){
            return null;
        }
        Node current = sentinel.next;
        return recursiveHelper(current, index);
    }

    /** recursive helper method for getRecursive method*/
    private T recursiveHelper(Node node, int index){
        if (index == 0){ //base case
            return node.value;
        }
        return recursiveHelper(node.next, index-1);
    }
}
