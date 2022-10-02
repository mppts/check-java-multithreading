package demos.t11_raceCondition;

public class App04_Race {
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        var threadA = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            while (Global.counter < 10)
                ++Global.counter;

            System.out.println("A");
        });
        var threadB = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            while (Global.counter < 10)
                --Global.counter;

            System.out.println("B");
        });

        threadA.start();
        threadB.start();
    }

    private static class Global {
        public static int counter = 0;
    }
}
