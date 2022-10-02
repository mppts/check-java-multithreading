package demos.t05_threadLists;

import java.util.stream.IntStream;

public class App02_Stream {
    public static void main(String[] args) {
        var threads = IntStream.range(0, 5).mapToObj(i -> new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            System.out.println(i);
        })).toList();

        for (var thread : threads)
            thread.start();
    }
}
