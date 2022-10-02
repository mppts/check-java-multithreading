package demos.t20_conditionVariable;

public class App02 {
    public static void main(String[] args) {
        var conditionVar = new Object();

        Runnable foo = () -> {
            try {
                System.out.println("foo is waiting...");

                synchronized (conditionVar) {
                    conditionVar.wait();
                }

                System.out.println("foo resumed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable bar = () -> {
            for (int i = 0; i < 3; ++i) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }

                synchronized (conditionVar) {
                    conditionVar.notify();
                }
            }
        };

        for (int i = 0; i < 3; ++i)
            new Thread(foo).start();

        new Thread(bar).start();
    }

}