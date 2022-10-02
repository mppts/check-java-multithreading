package demos.t23_volatile;

public class App01 {
    public static void main(String[] args) throws InterruptedException {
        Global.isRunning = true;
        new Thread(() -> doTask()).start();

        Thread.sleep(6000);
        Global.isRunning = false;
    }

    private static void doTask() {
        while (Global.isRunning) {
            System.out.println("Running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }

    private static class Global {
        public static volatile boolean isRunning;
    }
}
