// use functions

package demos.t00_intro;

public class App06_Function {
    public static void main(String[] args) {
        // with lambda
        var th1 = new Thread(() -> taskRunner());

        // with function reference
        var th2 = new Thread(App06_Function::taskRunner);

        th1.start();
        th2.start();

        System.out.println("Main thread");
    }

    private static void taskRunner() {
        System.out.println("Example thread");
    }
}
