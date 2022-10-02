package demos.t11_raceCondition;

import java.util.Arrays;

public class App02 {
    public static void main(String[] args) throws InterruptedException {
        final int N = 8;

        var a = new boolean[N + 1];
        Arrays.fill(a, false);

        var tDiv2 = new Thread(() -> {
            for (int i = 2; i <= N; i += 2)
                a[i] = true;
        });

        var tDiv3 = new Thread(() -> {
            for (int i = 3; i <= N; i += 3)
                a[i] = true;
        });

        tDiv2.start();
        tDiv3.start();
        tDiv2.join();
        tDiv3.join();

        int result = countTrue(a, N);
        System.out.println("Number of integers that are divisible by 2 or 3 is: " + result);
    }

    private static int countTrue(boolean[] a, int N) {
        int count = 0;

        for (int i = 1; i <= N; ++i)
            if (a[i])
                ++count;

        return count;
    }
}
