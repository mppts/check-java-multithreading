package demos.t05_threadLists;

import java.util.stream.IntStream;

public class App03_Stream {
    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(i -> new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            System.out.println(i);
        }).start());

    }
}
