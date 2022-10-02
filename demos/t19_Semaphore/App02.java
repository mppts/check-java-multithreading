package demos.t19_Semaphore;

import java.util.concurrent.Semaphore;

public class App02 {
    public static void main(String[] args) {
        var semPackage = new Semaphore(2); // if 0 then blocked
        var semSheet = new Semaphore(2);

        Runnable makeASheet = () -> {
            for (int i = 0; i < 4; i++) {
                try {
                    semSheet.acquire();
                    System.out.println("Make 1 sheet");
                    semSheet.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable combineToPack = () -> {
            for (int i = 0; i < 4; i++) {
                try {
                    semPackage.acquire(2);
                    System.out.println("Combine 2 sheets into 1 package: ");
                    Thread.sleep(1000);
                    semPackage.release(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(makeASheet).start();
        new Thread(makeASheet).start();
        new Thread(combineToPack).start();
    }
}
