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
            resize(size*2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1) % items.length;
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
            // DOWNSIZE CALL HERE downsize();
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

        int lastIndex = (nextLast - 1) % items.length;
        T value = items[lastIndex];
        size -= 1;
        nextLast = lastIndex;

        if (items.length > 16 && size < (items.length / 4)){
            // DOWNSIZE CALL HERE downsize();
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
        T[] newArray = (T[]) new Object[capacity];
        int subArraySize = size - nextLast; //size of the sub-array from first element to end of current array
        System.arraycopy(items, nextLast, newArray, 0, subArraySize); //takes the sub-array or start elements and copies to new array
        System.arraycopy(items, 0, newArray, subArraySize, nextLast); // takes the sub-array of end elements and copies to new array
        items = newArray;
        nextFirst = items.length-1;
        nextLast = size;
    }
}
