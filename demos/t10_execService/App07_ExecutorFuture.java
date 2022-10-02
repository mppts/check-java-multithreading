package demos.t10_execService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class App07_ExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int nThreads = 2;
        final int nTasks = 10;

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        System.out.println("Submit all tasks");

        var tasksList = IntStream.range(0, nTasks).mapToObj(i -> executor.submit(() -> (char) (i + 'A'))).toList();

        executor.shutdown();

        for (var task : tasksList) {
            System.out.println(task.get());
        }
    }
}
