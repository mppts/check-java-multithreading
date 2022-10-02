package demos.t19_Semaphore;

import java.util.concurrent.Semaphore;

public class App01 {
    public static void main(String[] args) {
        var sem = new Semaphore(0);

        Runnable makeASheet = () -> {
            for (int i = 0; i < 4; i++) {
                try {
                    System.out.println("Make 1 sheet");
                    Thread.sleep(500);
                    sem.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable combineToPack = () -> {
            for (int i = 0; i < 4; i++) {
                try {
                    sem.acquire(2);
                    System.out.println("Combine 2 sheets into 1 package: ");
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
