package demos.t04_id;

public class App {
    public static void main(String[] args) {
        Runnable taskRunner = () -> {
            var id = Thread.currentThread().getId();
            System.out.println(id);
        };

        var t1 = new Thread(taskRunner);
        var t2 = new Thread(taskRunner);

        System.out.println("T1: " + t1.getId());
        System.out.println("T2: " + t2.getId());

        t1.start();
        t2.start();
    }
}
