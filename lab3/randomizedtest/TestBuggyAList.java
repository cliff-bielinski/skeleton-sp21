package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(4);
        broken.addLast(4);
        correct.addLast(5);
        broken.addLast(5);
        correct.addLast(6);
        broken.addLast(6);

        assertEquals(correct.size(), broken.size());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggy.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = buggy.size();
                assertEquals(L.size(), buggy.size());
                System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() == 0) {continue;}
                int last = L.getLast();
                int last2 = buggy.getLast();
                assertEquals(last, last2);
                System.out.println("last: " + last);
            } else if (operationNumber == 3){
                //removeLast
                if (L.size() == 0) {continue;}
                int last = L.removeLast();
                int last2 = buggy.removeLast();
                assertEquals(last, last2);
                System.out.println("removed: " + last);
            }
        }
    }
}
