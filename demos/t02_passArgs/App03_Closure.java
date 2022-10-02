// pass args to closure
// !!! The captured variables must be final or effectively final.

package demos.t02_passArgs;

/**
 * App01_Thread
 */
public class App03_Closure {

    public static void main(String[] args) {
        int MAX = 10;

        new Thread(() -> {
            for (int i = 0; i < MAX; i++) {
                System.out.printf("%d...", i);
            }
        }).start();
    }
}
