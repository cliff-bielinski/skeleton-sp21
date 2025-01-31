package deque;

import org.junit.Test;
import static org.junit.Assert.*;

/** Performs basic array deque tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few elements to the front and back of the ArrayDeque and checks
     * the functionality of size() and isEmpty().
     */
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        assertTrue("A newly initialized ArrayDeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        ad1.addFirst("frontest");
        assertEquals(4, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }
    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ad1.addFirst(10);
        // should not be empty
        assertFalse("ad1 should contain 1 item", ad1.isEmpty());

        ad1.removeFirst();
        // should be empty
        assertTrue("ad1 should be empty after removal", ad1.isEmpty());
    }

    @Test
    /* Adds items to array using addLast, then checks value of items at different indices and compares to expected values */
    public void addLastGetTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
        }

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        for (int i = 0; i < 10; i++) {
            int value = ad1.get(i);
            assertEquals(i, value);
        }

        assertEquals(null, ad1.get(20));
    }

    @Test
    /* Adds items to array using addFirst, then checks value of items at different indices and compares to expected values */
    public void addFirstGetTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ad1.addFirst(i);
        }

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        for (int i = 0; i < 10; i++) {
            int value = ad1.get(i);
            assertEquals(9-i, value);
        }

        assertEquals(null, ad1.get(20));
    }

    @Test
    /* Removes items from the array using addFirst, checks for proper removal and resizing of deque */
    public void removeManyFirst() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        for (int i = 0; i < 1000; i++) {
            ad1.addFirst(i);
        }

        assertEquals(1000, ad1.size());
        assertEquals(1024, ad1.containerSize());

        for (int i = 0; i < 1000; i++) {
            ad1.removeFirst();
        }

        assertEquals(0, ad1.size());
        assertEquals(16, ad1.containerSize());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigADequeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            ad1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }
    }

    @Test
    /* Iterates through an arraydeque using an iterator object */
    public void iteratorTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 1; i < 100; i*=2) {
            ad1.addLast(i);
        }
        int test = 1;
        for (int i : ad1){
            assertEquals(i, test);
            test *= 2;
        }
    }

    @Test
    /* tests the equal functionality to see if comparator is an equivalent Deque */
    public void equalsTest(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> ad3 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> ad4 = new ArrayDeque<Integer>();

        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);
        ad2.addFirst(1);
        ad2.addFirst(2);
        ad2.addFirst(3);
        ad3.addFirst(4);
        ad3.addFirst(5);
        ad3.addFirst(6);

        assertTrue(ad1.equals(ad2));
        assertFalse(ad1.equals(ad3));
        assertFalse(ad1.equals(ad4));
    }
}
