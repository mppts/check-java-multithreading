package demos.t06_terminate;

public class App01_Interrupted {
    public static void main(String[] args) throws InterruptedException {
        var th = new Thread(() -> {
            while (true) {
                System.out.println("Running...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });

        th.start();

        Thread.sleep(2000);

        th.interrupt();
    }
}
