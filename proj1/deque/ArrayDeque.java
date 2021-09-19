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

    /** returns the current size of the array containing the deque (debugging only) */
    public int containerSize() {
        return items.length;
    }

    /** adds an element to the start of the ArrayDeque */
    public void addFirst(T item){
        if (size == items.length){
            resize(size*2);
        }
        items[nextFirst] = item;
        nextFirst = Math.floorMod(nextFirst - 1, items.length);
        size += 1;
    }

    /** removes the first element from the ArrayDeque and returns it*/
    public T removeFirst(){
        if (size == 0){
            return null;
        }

        int firstIndex = (nextFirst + 1) % items.length;
        T value = items[firstIndex];
        size -= 1;
        nextFirst = firstIndex;

        if (items.length > 16 && size < (items.length / 4)){
            resize(items.length / 2);
        }

        return value;
    }

    /** adds an element to the end of the ArrayDeque */
    public void addLast(T item){
        if (size == items.length){
            resize(size*2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /** removes an element at the end of the ArrayDeque */
    public T removeLast(){
        if (size == 0){
            return null;
        }

        int lastIndex = Math.floorMod(nextLast - 1, items.length);
        T value = items[lastIndex];
        size -= 1;
        nextLast = lastIndex;

        if (items.length > 16 && size < (items.length / 4)){
            resize(items.length / 2);
        }

        return value;
    }

    /** returns the value of an element at a given index in the ArrayDeque */
    public T get(int index){
        if (index >= size){
            return null;
        }

        int newIndex = (nextFirst + index + 1) % items.length;
        return items[newIndex];
    }

    /** prints out the elements in the ArrayDeque */
    public void printDeque(){
        for (int i = 0; i < size; i++){
            int newIndex = (nextFirst + i + 1) % items.length;
            T current = items[newIndex];
            System.out.print(current + " ");
        }
        System.out.println();
    }

    /** resizes the array to capacity size */
    private void resize(int capacity){
        int head = (nextFirst + 1) % items.length;
        T[] newArray = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++){
            int currentIndex = (head + i) % items.length;
            newArray[i] = items[currentIndex];
        }

        items = newArray;
        nextFirst = items.length - 1;
        nextLast = size;
    }
}
