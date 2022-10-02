package demos.t10_execService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App05_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();

        Future<Integer> task = exec.submit(() -> getSquared(12));

        exec.shutdown();

        // As Future.get waits if necessary for computation to complete
        // we may omit while loop below
        while (!task.isDone()) {
            // do nothing
        }

        int res = task.get();
        System.out.println(res);
    }

    private static int getSquared(int arg) {
        return arg * arg;
    }

}
