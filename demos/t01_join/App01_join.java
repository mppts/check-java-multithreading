package demos.t01_join;

public class App01_join {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> heavyTaskRunner());

        th1.start();
        th1.join();

        System.out.println("Main Thread");
    }

    @SuppressWarnings("unused")
    private static void heavyTaskRunner() {
        long k = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            k++;
        }

        System.out.println("Example thread heavy");
    }
}
