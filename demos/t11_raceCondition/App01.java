package demos.t11_raceCondition;

import java.util.stream.IntStream;

public class App01 {
    public static void main(String[] args) {
        final int nThreads = 4;

        var tasksList = IntStream.range(0, nThreads)
                .mapToObj(i -> new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.print(i);
                }))
                .toList();

        tasksList.forEach(Thread::start);
    }
}
