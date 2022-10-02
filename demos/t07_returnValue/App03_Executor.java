package demos.t07_returnValue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App03_Executor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var calc = new InnerApp03_Executor();

        var futRes = calc.calculate(20);

        var res = futRes.get();

        System.out.println("Result: " + res);

        calc.shutdown();
    }
}

/**
 * InnerApp03_Executor - Claculator
 */
class InnerApp03_Executor {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer arg) {
        return executor.submit(() -> {
            Thread.sleep(500);
            return arg * 3;
        });
    }

    public void shutdown() {
        executor.shutdown();
    }

}