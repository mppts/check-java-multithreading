package demos.t10_execService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class App03_Executor {
    public static void main(String[] args) throws InterruptedException {
        final int nThreads = 2;
        final int nTasks = 5;

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        IntStream.range(0, nTasks).forEach(i -> executor.submit(() -> {
            char taskName = (char) (i + 'A');
            System.out.println("Task %c is starting".formatted(taskName));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }

            System.out.println("Task %c is completed".formatted(taskName));
        }));

        executor.shutdown();

        System.out.println("All tasks are submitted");

        // Blocks until all tasks have completed execution after a shutdown request,
        // or the timeout occurs, or the current thread is interrupted, whichever
        // happens first.
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("All tasks are completed");
    }
}
