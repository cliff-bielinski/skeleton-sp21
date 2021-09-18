package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();

        for (int i = 0; i < 8; i++) {
            int arraySize = (int) Math.pow(2, i);
            arraySize = arraySize * 1000;
            SLList<Integer> test = new SLList<Integer>();
            int opCount = 0;


            for (int j = 0; j < arraySize; j++) {
                test.addLast(j);
            }

            Stopwatch sw = new Stopwatch();
            while (opCount < 10000){
                test.getLast();
                opCount += 1;
            }
            double timeInSeconds = sw.elapsedTime();

            Ns.addLast(test.size());
            times.addLast(timeInSeconds);
            opCounts.addLast(opCount);
        }
        printTimingTable(Ns, times, opCounts);
    }

}
