package demos.t05_threadLists;

import java.util.ArrayList;

public class App01_List {
    public static void main(String[] args) {
        final int NUM = 4;

        var threads = new ArrayList<Thread>();

        for (int i = 0; i < NUM; i++) {
            final int idx = i;

            threads.add(new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                System.out.println(idx);
                ;
            }));
        }

        threads.forEach(Thread::start);
    }
}
