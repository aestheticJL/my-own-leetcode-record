import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Test {
    volatile static int a = 0;

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        int b = a;
        a++;
        System.out.println(b);
    }
}
