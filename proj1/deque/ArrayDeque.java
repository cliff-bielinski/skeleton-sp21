package deque;

public class ArrayDeque <T>{
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    /** Initializes an ArrayDeque object */
    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
    }

    /** adds an element to the start of the ArrayDeque */
    public void addFirst(T item){
        if (size == items.length){
            //RESIZE CALL HERE resize();
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1) % size;
    }
}
