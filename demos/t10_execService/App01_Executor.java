// example of thread pool by executor
// single thread is used to create event loops

package demos.t10_execService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App01_Executor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> System.out.println("Example thread 1"));
        executor.submit(() -> System.out.println("Example thread 2"));

        Runnable rn = () -> System.out.println("Example thread 3");

        executor.submit(rn);

        executor.shutdown();
    }
}
