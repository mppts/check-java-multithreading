package demos.t10_execService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App04_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();

        Future<String> task = exec.submit(() -> "Rick rolled!");

        exec.shutdown();

        while (!task.isDone()) {
            // do nothing
        }

        String res = task.get();
        System.out.println(res);
    }
}
