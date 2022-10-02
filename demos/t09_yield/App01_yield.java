package demos.t09_yield;

import java.time.Duration;
import java.time.Instant;

public class App01_yield {
    public static void main(String[] args) {
        var timeStart = Instant.now();

        customSleep(130000);

        var timeElapsed = Duration.between(timeStart, Instant.now());

        System.out.println("Elapsed time: " + timeElapsed.toNanos() + " nanoseonds");
    }

    private static void customSleep(int ns) {
        var tpStart = Instant.now();
        var tpEnd = tpStart.plusNanos(ns);

        do {
            Thread.yield();
        } while (Instant.now().isBefore(tpEnd));
    }
}
