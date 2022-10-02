// pass args to function

package demos.t02_passArgs;

/**
 * App01_Thread
 */
public class App02_Function {

    public static void main(String[] args) {
        var t1 = new Thread(() -> taskRunner(3, "Example thread "));

        t1.start();
    }

    private static void taskRunner(int i, String s) {
        System.out.printf("%d. %s\n", i, s);
    }
}
