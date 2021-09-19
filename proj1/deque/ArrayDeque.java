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

    /** checks whether the ArrayDeque is empty */
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    /** returns the current size of the ArrayDeque */
    public int size(){
        return size;
    }

    /** adds an element to the start of the ArrayDeque */
    public void addFirst(T item){
        if (size == items.length){
            //RESIZE CALL HERE resize();
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1) % items.length;
        size += 1;
    }

    /** adds an element to the end of the ArrayDeque */
    public void addLast(T item){
        if (size == items.length){
            //RESIZE CALL HERE resize();
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /** prints out the elements in the ArrayDeque */
    public void printDeque(){
        for (int i = 0; i < size; i++){
             T current = items[nextFirst + 1 + i];
            System.out.print(current + " ");
        }
        System.out.println();
    }
}
