package demos.t10_execService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class App08_ExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int nThreads = 2;
        final int nTasks = 10;

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        var todos = IntStream.range(0, nTasks)
                .mapToObj(i -> (Callable<String>) () -> taskRunner(i))
                .toList();

        // Waits when all futures will be done
        var tasksList = executor.invokeAll(todos);

        System.out.println("All tasks are completed");
        executor.shutdown();

        for (var task : tasksList) {
            System.out.println(task.get());
        }
    }

    private static String taskRunner(Integer arg) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("End of " + arg);
        return arg + " is done (it's a result)";
    }
}
