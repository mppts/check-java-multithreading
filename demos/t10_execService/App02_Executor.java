package demos.t10_execService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class App02_Executor {
    public static void main(String[] args) {
        final int nThreads = 2;
        final int nTasks = 5;

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        IntStream.range(0, nTasks).forEach(i -> executor.submit(() -> {
            char taskName = (char) (i + 'A');
            System.out.println("Task %c is starting".formatted(taskName));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

            System.out.println("Task %c is completed".formatted(taskName));
        }));

        executor.shutdown();
    }
}
