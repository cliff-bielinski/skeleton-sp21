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

    /** removes the first element from the ArrayDeque and returns it*/
    public T removeFirst(){
        int firstIndex = (nextFirst + 1) % items.length;
        T value = items[firstIndex];
        size -= 1;
        nextFirst = firstIndex;
        if (items.length > 16 && size < (items.length / 4)){
            // DOWNSIZE CALL HERE downsize();
        }
        return value;
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

    /** removes an element at the end of the ArrayDeque */
    public T removeLast(){
        int lastIndex = (nextLast - 1) % items.length;
        T value = items[lastIndex];
        size -= 1;
        nextLast = lastIndex;
        if (items.length > 16 && size < (items.length / 4)){
            // DOWNSIZE CALL HERE downsize();
        }
        return value;
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
