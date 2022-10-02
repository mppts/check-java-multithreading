package demos.t10_execService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App06_Future {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> callable = () -> getSquared(11);
        Future<Integer> task = executor.submit(callable);

        System.out.println("calculating...");

        executor.shutdown();

        Integer res = task.get();
        System.out.println(res);

    }

    private static Integer getSquared(Integer arg) {
        return arg * arg;
    }
}
